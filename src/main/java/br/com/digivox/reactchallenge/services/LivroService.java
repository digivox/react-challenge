package br.com.digivox.reactchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro addLivro(Livro livro) {
		return livroRepository.save(livro);
		
	}

}
