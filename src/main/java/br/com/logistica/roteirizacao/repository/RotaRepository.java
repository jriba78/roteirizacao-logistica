package br.com.logistica.roteirizacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logistica.roteirizacao.entity.Rota;

public interface RotaRepository extends JpaRepository<Rota, Long> {

	@EntityGraph(attributePaths = { "motorista", "veiculo", "paradas", "paradas.entrega", "paradas.entrega.cliente" })
	@Override
	List<Rota> findAll();

	@EntityGraph(attributePaths = { "motorista", "veiculo", "paradas", "paradas.entrega", "paradas.entrega.cliente" })
	@Override
	Optional<Rota> findById(Long id);
}
