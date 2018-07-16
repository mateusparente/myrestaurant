package br.com.mateusparente.meurestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateusparente.meurestaurante.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}