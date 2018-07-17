package br.com.mateusparente.meurestaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@GetMapping
    public String index() {
		return "My Favorite Restaurant API";
	}
	
}