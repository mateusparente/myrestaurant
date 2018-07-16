package br.com.mateusparente.meurestaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@GetMapping
    public String index() {
		
		return "Hello world";
		
	}
	
}
