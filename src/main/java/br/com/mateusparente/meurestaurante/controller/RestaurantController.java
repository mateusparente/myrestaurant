package br.com.mateusparente.meurestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateusparente.meurestaurante.model.Restaurant;
import br.com.mateusparente.meurestaurante.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantRepository repository;
	
	@GetMapping
    public List<Restaurant> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody final Restaurant restaurant){
		repository.save(restaurant);
	}
	
}
