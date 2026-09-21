package br.com.logistica.roteirizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logistica.roteirizacao.entity.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

	boolean existsByCnh(String cnh);

	boolean existsByCnhAndIdNot(String cnh, Long id);
}
