package br.com.mateusparente.meurestaurante;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mateusparente.meurestaurante.model.Rate;
import br.com.mateusparente.meurestaurante.model.Restaurant;
import br.com.mateusparente.meurestaurante.model.User;
import br.com.mateusparente.meurestaurante.repository.RestaurantRepository;
import br.com.mateusparente.meurestaurante.service.RestaurantService;

@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({
    @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
    @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql") })
public class RestaurantServiceImplTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Test
	public void rateOneRestaurant(){
		
		Optional<Restaurant> restaurantRated = restaurantRepository.findById(100L);
		assertEquals(0, restaurantRated.get().getRates().size());
		
		Rate rate = new Rate();
		rate.setRestaurant(new Restaurant(100L));
		rate.setUser(new User(100L));
		
		restaurantService.rate(rate);
		entityManager.flush();
		entityManager.clear();
		
		restaurantRated = restaurantRepository.findById(100L);
		assertEquals(1, restaurantRated.get().getRates().size());
		
	}
	
}
