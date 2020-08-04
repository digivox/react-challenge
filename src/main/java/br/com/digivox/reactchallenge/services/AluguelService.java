package br.com.digivox.reactchallenge.services;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		
		aluguel.setDataDeCriacao(new Date());
		
		if(aluguel.getDataDeRetirada() != null) {
			
			LocalDateTime dataDaRetirada = aluguel.getDataDeRetirada().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();  
			
			LocalDateTime dataPrevistaParaDevolucao = dataDaRetirada.plusDays(7);
					
			aluguel.setDataPrevistaParaDevolucao(Date.from(dataPrevistaParaDevolucao.atZone(ZoneId.systemDefault()).toInstant()));
			
			for(Livro livro : aluguel.getLivros()) {
				livro.setStatus(LivroStatus.RESERVADO);
				livroService.update(livro);
			}
			
			aluguel.setStatus(AluguelStatus.RESERVADO);
			
		} else {
			LocalDateTime hoje = LocalDateTime.now();;  
			
			LocalDateTime dataParaDevolucao = hoje.plusDays(7);
					
			aluguel.setDataPrevistaParaDevolucao(Date.from(dataParaDevolucao.atZone(ZoneId.systemDefault()).toInstant()));
			
			for(Livro livro : aluguel.getLivros()) {
				livro.setStatus(LivroStatus.EM_UTILIZACAO);
				livroService.update(livro);
			}
			
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
	
	public Page<Aluguel> alugueisPrevistoParaDevolucao(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		
		LocalDate hoje = LocalDate.now();
		
		LocalDate domingoInLocalDate = hoje.with(nextOrSame(SUNDAY));
	    LocalDate segundaInLocalDate = hoje.with(previousOrSame(MONDAY));
	    
	    Date domingoInDate = Date.from(domingoInLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    Date segundaInDate = Date.from(segundaInLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    
		return aluguelRepository.findByDataPrevistaParaDevolucaoBetween(segundaInDate, domingoInDate, pageRequest);
	}
	
	public Aluguel devolverLivroAlugado(Aluguel aluguel) {
		for(Livro livro : aluguel.getLivros()) {
			livroService.atualizaStatus(livro, LivroStatus.DISPONIVEL);
		}
		
		aluguel.setDataDeDevolucao(new Date());
		aluguel.setStatus(AluguelStatus.FINALIZADA);
		
		return update(aluguel);
	}

	public Page<Aluguel> alugadosNaSemana(Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		
		LocalDate hoje = LocalDate.now();
		
		LocalDate domingoInLocalDate = hoje.with(nextOrSame(SUNDAY));
	    LocalDate segundaInLocalDate = hoje.with(previousOrSame(MONDAY));
	    
	    Date domingoInDate = Date.from(domingoInLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    Date segundaInDate = Date.from(segundaInLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    
		return aluguelRepository.findByDataDeCriacaoBetween(segundaInDate, domingoInDate, pageRequest);
	}

}
