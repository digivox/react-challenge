package br.com.digivox.reactchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.enums.LivroStatus;
import br.com.digivox.reactchallenge.repositories.LivroRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro addLivro(Livro livro) {
		livro.setStatus(LivroStatus.DISPONIVEL);
		return livroRepository.save(livro);
	}
	
	public List<Livro> findAllByCodigoISBN(String isbn) throws ObjectNotFoundException {	
		return livroRepository.findAllByCodigoISBN(isbn);
	}
	
	public List<Livro> listAll() {
		return livroRepository.findAll();
	}
	
	public List<Livro> listAllDisponiveis() {
		return livroRepository.findAllByStatus(LivroStatus.DISPONIVEL);
	}
	
	public void update(Livro livro) {
		livroRepository.saveAndFlush(livro);
	}
}
