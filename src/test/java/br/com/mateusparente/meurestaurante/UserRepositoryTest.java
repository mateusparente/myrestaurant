package br.com.mateusparente.meurestaurante;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mateusparente.meurestaurante.model.Rate;
import br.com.mateusparente.meurestaurante.model.Restaurant;
import br.com.mateusparente.meurestaurante.model.User;
import br.com.mateusparente.meurestaurante.repository.RestaurantRepository;
import br.com.mateusparente.meurestaurante.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Test
	public void createUserWithRate(){
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Restaurant 01");
		
		restaurantRepository.saveAndFlush(restaurant);
		
		Rate rate = new Rate();
		rate.setRestaurant(restaurant);
		
		User r = new User();
		r.setName("First user example");
		r.addRate(rate);
		
		repository.save(r);
		
		entityManager.flush();
		entityManager.clear();
		
		List<User> users = repository.findAll();
		assertEquals("First user example", users.get(0).getName());
		assertEquals("Restaurant 01", users.get(0).getRates().get(0).getRestaurant().getName());
		
	}
	
}
