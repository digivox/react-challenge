package br.com.digivox.reactchallenge.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digivox.reactchallenge.domain.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
	
	Page<Aluguel> findByDataPrevistaParaDevolucaoBetween(Date segunda, Date domingo, Pageable pageRequest);
	
	Page<Aluguel> findByDataDeCriacaoBetween(Date segunda, Date domingo, Pageable pageRequest);

}
