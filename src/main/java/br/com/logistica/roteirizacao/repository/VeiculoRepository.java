package br.com.logistica.roteirizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logistica.roteirizacao.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	boolean existsByPlaca(String placa);

	boolean existsByPlacaAndIdNot(String placa, Long id);
}
