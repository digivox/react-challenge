package br.com.digivox.reactchallenge.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.domain.Reserva;
import br.com.digivox.reactchallenge.enums.LivroStatus;
import br.com.digivox.reactchallenge.enums.ReservaStatus;
import br.com.digivox.reactchallenge.repositories.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private LivroService livroService;
	
	@Transactional
	public Reserva createReserva(Reserva reserva) {
		
		for(Livro livro : reserva.getLivros()) {
			livro.setStatus(LivroStatus.RESERVADO);
			livroService.update(livro);
		}
		
		reserva.setDataDeCriacao(new Date());
		
		LocalDateTime dataDaRetirada = reserva.getDataDeRetirada().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();  
		
		LocalDateTime dataParaEntrega = dataDaRetirada.plusDays(7);
				
		reserva.setDataDeEntrega(Date.from(dataParaEntrega.atZone(ZoneId.systemDefault()).toInstant()));
		
		reserva.setStatus(ReservaStatus.CRIADA);
		
		return reservaRepository.save(reserva);
	}
	
	public Reserva findById(Integer id) throws ObjectNotFoundException {
		 Optional<Reserva> reserva = reservaRepository.findById(id);
		 return reserva.orElseThrow(() -> new ObjectNotFoundException(
					"Livro com o id " + id + " não encontrado", null)); 
	}
	
	public Reserva atualizaStatus(Reserva reserva, ReservaStatus novoStatus) {
		reserva.setStatus(novoStatus);
		return update(reserva);
	}

	public Reserva cancelarReserva(Reserva reserva) {
		return atualizaStatus(reserva, ReservaStatus.CANCELADA);
	}
	
	public Reserva update(Reserva reserva) {
		return reservaRepository.saveAndFlush(reserva);
	}

}
