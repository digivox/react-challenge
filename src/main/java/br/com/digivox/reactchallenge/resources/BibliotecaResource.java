package br.com.digivox.reactchallenge.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digivox.reactchallenge.domain.Aluguel;
import br.com.digivox.reactchallenge.domain.Reserva;
import br.com.digivox.reactchallenge.services.AluguelService;
import br.com.digivox.reactchallenge.services.BibliotecaService;
import br.com.digivox.reactchallenge.services.ReservaService;

@RestController
@RequestMapping(value="/biblioteca")
public class BibliotecaResource {
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private AluguelService aluguelService;
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
	@CrossOrigin
	@RequestMapping(value = "/reservar", method = RequestMethod.POST)
	public ResponseEntity<?> createReserva(@RequestBody Reserva reserva) {
		reserva = reservaService.createReserva(reserva);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(reserva.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/aluguar", method = RequestMethod.POST)
	public ResponseEntity<?> createReserva(@RequestBody Aluguel aluguel) {
		aluguel = aluguelService.createAluguel(aluguel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(aluguel.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/cancelar/reserva", method = RequestMethod.POST)
		public ResponseEntity<?> cancelarReserva(@RequestBody Reserva reserva) {
		reserva = reservaService.cancelarReserva(reserva);
		return ResponseEntity.ok(reserva);
	}
	
	@RequestMapping(value = "/devolver/livroalugado", method = RequestMethod.POST)
	public ResponseEntity<?> devolverLivroAlugado(@RequestBody Aluguel aluguel) {
		bibliotecaService.devolverLivro(null, aluguel);
		return (ResponseEntity<?>) ResponseEntity.ok();
	}
	
	@RequestMapping(value = "/devolver/livroreservado", method = RequestMethod.POST)
	public ResponseEntity<?> devolverLivroAlugado(@RequestBody Reserva reserva) {
		bibliotecaService.devolverLivro(reserva, null);
		return (ResponseEntity<?>) ResponseEntity.ok();
	}


}
