package br.com.digivox.reactchallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.enums.LivroStatus;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	List<Livro> findAllByCodigoISBN(String codigoISBN);
	
	List<Livro> findAllByStatus(LivroStatus livroStatus);

}
