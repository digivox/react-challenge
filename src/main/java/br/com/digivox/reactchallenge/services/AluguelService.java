package br.com.digivox.reactchallenge.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Aluguel;
import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.enums.LivroStatus;
import br.com.digivox.reactchallenge.repositories.AluguelRepository;

@Service
public class AluguelService {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private LivroService livroService;

	public Aluguel createAluguel(Aluguel aluguel) {
		
		for(Livro livro : aluguel.getLivros()) {
			livro.setStatus(LivroStatus.RESERVADO);
			livroService.update(livro);
		}
		
		aluguel.setDataDeCriacao(new Date());
		
		LocalDateTime hoje = LocalDateTime.now();;  
		
		LocalDateTime dataParaEntrega = hoje.plusDays(7);
				
		aluguel.setDataDeEntrega(Date.from(dataParaEntrega.atZone(ZoneId.systemDefault()).toInstant()));
		
		return aluguelRepository.save(aluguel);
	}
	
	

}
