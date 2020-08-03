package br.com.digivox.reactchallenge.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Aluguel;
import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.enums.AluguelStatus;
import br.com.digivox.reactchallenge.enums.LivroStatus;
import br.com.digivox.reactchallenge.repositories.AluguelRepository;

@Service
public class AluguelService {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private LivroService livroService;
	
	public Aluguel findById(Integer id) throws ObjectNotFoundException {
		 Optional<Aluguel> aluguel = aluguelRepository.findById(id);
		 return aluguel.orElseThrow(() -> new ObjectNotFoundException(
					"Livro com o id " + id + " não encontrado", null)); 
	}

	public Aluguel createAluguel(Aluguel aluguel) {
		
		for(Livro livro : aluguel.getLivros()) {
			livro.setStatus(LivroStatus.EM_UTILIZACAO);
			livroService.update(livro);
		}
		
		aluguel.setDataDeCriacao(new Date());
		
		if(aluguel.getDataDeRetirada() == null) {
			
			LocalDateTime dataDaRetirada = aluguel.getDataDeRetirada().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();  
			
			LocalDateTime dataPrevistaParaDevolucao = dataDaRetirada.plusDays(7);
					
			aluguel.setDataPrevistaParaDevolucao(Date.from(dataPrevistaParaDevolucao.atZone(ZoneId.systemDefault()).toInstant()));
			
			aluguel.setStatus(AluguelStatus.RESERVADO);
			
		} else {
			LocalDateTime hoje = LocalDateTime.now();;  
			
			LocalDateTime dataParaDevolucao = hoje.plusDays(7);
					
			aluguel.setDataDeDevolucao(Date.from(dataParaDevolucao.atZone(ZoneId.systemDefault()).toInstant()));
			
			aluguel.setStatus(AluguelStatus.EM_ANDAMENTO);
			
		}	
		
		return aluguelRepository.save(aluguel);
	}
	
	public Aluguel atualizaStatus(Aluguel aluguel, AluguelStatus novoStatus) {
		aluguel.setStatus(novoStatus);
		return update(aluguel);
	}
	
	public Aluguel update(Aluguel aluguel) {
		return aluguelRepository.saveAndFlush(aluguel);
	}

}
