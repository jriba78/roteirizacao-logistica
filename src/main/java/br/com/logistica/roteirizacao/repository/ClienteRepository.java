package br.com.logistica.roteirizacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logistica.roteirizacao.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	boolean existsByEmail(String email);

	boolean existsByEmailAndIdNot(String email, Long id);

	Optional<Cliente> findByEmail(String email);
}
