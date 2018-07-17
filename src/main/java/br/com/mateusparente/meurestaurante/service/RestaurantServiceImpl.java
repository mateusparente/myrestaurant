package br.com.mateusparente.meurestaurante.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mateusparente.meurestaurante.exception.RepeatedRateException;
import br.com.mateusparente.meurestaurante.model.Rate;
import br.com.mateusparente.meurestaurante.model.Restaurant;
import br.com.mateusparente.meurestaurante.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private RestaurantRepository repository;
	
	@SuppressWarnings("unchecked")
	@Override
	public void rate(Rate rate) {

		Query query = entityManager.createQuery("from Rate where restaurant.id = :restaurantID and user.id = :userID and rateDate = :today");
		query.setParameter("restaurantID", rate.getRestaurant().getId());
		query.setParameter("userID", rate.getUser().getId());
		query.setParameter("today", new Date());
		
		List<Rate> rateExisted = query.getResultList();
		
		if(rateExisted.size() > 0){
			throw new RepeatedRateException("already rated!");
		}
		
		Optional<Restaurant> restaurantManaged = repository.findById(rate.getRestaurant().getId());
		restaurantManaged.ifPresent(restaurant -> {
			
			restaurant.addRateCount();
			
			repository.save(restaurant);
			
			entityManager.persist(rate);
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Restaurant showTopRated() {

		Query query = entityManager.createQuery("from Restaurant order by ratesCount desc ");
		query.setMaxResults(1);
		
		Optional<Restaurant> first = query.getResultList().stream().findFirst();
		
		if(first.isPresent()){
			return first.get();
		}
		
		return null;
	}
}