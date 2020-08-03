package br.com.digivox.reactchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Aluguel;
import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.domain.Reserva;
import br.com.digivox.reactchallenge.enums.LivroStatus;
import br.com.digivox.reactchallenge.enums.ReservaStatus;

@Service
public class BibliotecaService {
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private LivroService livroService;

	public void devolverLivro(Reserva reserva, Aluguel aluguel) {
		if(reserva != null) {
			
			for(Livro livro : reserva.getLivros()) {
				livroService.atualizaStatus(livro, LivroStatus.DISPONIVEL);
			}
			
			reservaService.atualizaStatus(reserva, ReservaStatus.FINALIZADA);
			
		} else {
			
			for(Livro livro : aluguel.getLivros()) {
				livroService.atualizaStatus(livro, LivroStatus.DISPONIVEL);
			}
			
		}	
	}

}
