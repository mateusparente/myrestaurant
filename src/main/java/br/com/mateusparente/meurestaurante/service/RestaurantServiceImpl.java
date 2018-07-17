package br.com.mateusparente.meurestaurante.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.com.mateusparente.meurestaurante.model.Rate;
import br.com.mateusparente.meurestaurante.model.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void rate(Rate rate) {

		entityManager.persist(rate);
		
	}

	@Override
	public Restaurant showTopRated() {

		return null;
	}

	
	
}