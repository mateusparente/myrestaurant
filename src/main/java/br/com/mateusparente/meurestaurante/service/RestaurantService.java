package br.com.mateusparente.meurestaurante.service;

import br.com.mateusparente.meurestaurante.model.Rate;
import br.com.mateusparente.meurestaurante.model.Restaurant;

public interface RestaurantService {

	public void rate(Rate rate);
	
	public Restaurant showTopRated();
	
}