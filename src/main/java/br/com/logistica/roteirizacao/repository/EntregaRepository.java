package br.com.logistica.roteirizacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logistica.roteirizacao.domain.StatusEntrega;
import br.com.logistica.roteirizacao.entity.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

	@EntityGraph(attributePaths = "cliente")
	@Override
	List<Entrega> findAll();

	@EntityGraph(attributePaths = "cliente")
	@Override
	Optional<Entrega> findById(Long id);

	@EntityGraph(attributePaths = "cliente")
	List<Entrega> findByStatus(StatusEntrega status);

	@EntityGraph(attributePaths = "cliente")
	List<Entrega> findByClienteId(Long clienteId);
}
