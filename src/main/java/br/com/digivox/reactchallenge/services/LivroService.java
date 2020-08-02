package br.com.digivox.reactchallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.repositories.LivroRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro addLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro findByLivroId(Integer livroId) throws ObjectNotFoundException {	
		Optional<Livro> livro =  livroRepository.findById(livroId);
		return livro.orElseThrow(() -> new ObjectNotFoundException(
				"Livro com o id " + livroId + " não encontrado")); 
	}

}
