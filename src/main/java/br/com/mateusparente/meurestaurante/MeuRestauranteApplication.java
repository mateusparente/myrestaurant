package br.com.mateusparente.meurestaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("br.com.mateusparente.meurestaurante")
public class MeuRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuRestauranteApplication.class, args);
	}
}
