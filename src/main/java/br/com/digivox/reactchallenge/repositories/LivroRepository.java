package br.com.digivox.reactchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digivox.reactchallenge.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
