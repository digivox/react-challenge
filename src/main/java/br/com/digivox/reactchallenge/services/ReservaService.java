package br.com.digivox.reactchallenge.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Reserva;
import br.com.digivox.reactchallenge.repositories.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private LivroService livroService;
	
	public Reserva createReserva(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	public Reserva findById(Integer id) throws ObjectNotFoundException {
		 Optional<Reserva> reserva = reservaRepository.findById(id);
		 return reserva.orElseThrow(() -> new ObjectNotFoundException(
					"Livro com o id " + id + " não encontrado", null)); 
	}

}
