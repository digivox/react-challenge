package br.com.digivox.reactchallenge.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Aluguel;
import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.enums.AluguelStatus;
import br.com.digivox.reactchallenge.enums.LivroStatus;

@Service
public class BibliotecaService {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private AluguelService aluguelService;
	
	public Aluguel devolverLivroAlugado(Aluguel aluguel) {
		for(Livro livro : aluguel.getLivros()) {
			livroService.atualizaStatus(livro, LivroStatus.DISPONIVEL);
		}
		
		aluguel.setDataDeDevolucao(new Date());
		aluguel.setStatus(AluguelStatus.FINALIZADA);
		
		return aluguelService.update(aluguel);
	}
	
}
