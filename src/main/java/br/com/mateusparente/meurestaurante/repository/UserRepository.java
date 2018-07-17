package br.com.mateusparente.meurestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateusparente.meurestaurante.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
