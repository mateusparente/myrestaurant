package br.com.mateusparente.meurestaurante;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mateusparente.meurestaurante.model.Restaurant;
import br.com.mateusparente.meurestaurante.repository.RestaurantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantRepositoryTest {

	@Autowired
	private RestaurantRepository repository;
	
	@Test
	public void createRestaurant(){
		
		Restaurant r = new Restaurant();
		r.setName("First restaurant example");
		
		repository.save(r);
		
		List<Restaurant> restaurants = repository.findAll();
		assertEquals("First restaurant example", restaurants.get(0).getName());
		
	}
	
}