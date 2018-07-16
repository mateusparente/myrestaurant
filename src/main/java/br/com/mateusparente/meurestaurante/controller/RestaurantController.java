package br.com.mateusparente.meurestaurante.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public void save(@RequestBody @Valid final Restaurant restaurant){
		repository.save(restaurant);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult()
	        .getAllErrors().stream()
	        .map(ObjectError::getDefaultMessage)
	        .collect(Collectors.toList());
	}
}