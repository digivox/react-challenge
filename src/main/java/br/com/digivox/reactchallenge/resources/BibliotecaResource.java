package br.com.digivox.reactchallenge.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digivox.reactchallenge.domain.Aluguel;
import br.com.digivox.reactchallenge.enums.AluguelStatus;
import br.com.digivox.reactchallenge.services.AluguelService;
import br.com.digivox.reactchallenge.services.BibliotecaService;

@RestController
@RequestMapping(value="/biblioteca")
public class BibliotecaResource {
	
	@Autowired
	private AluguelService aluguelService;
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
	@RequestMapping(value = "/alugar", method = RequestMethod.POST)
	public ResponseEntity<?> createAluguel(@RequestBody Aluguel aluguel) {
		aluguel = aluguelService.createAluguel(aluguel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(aluguel.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/cancelar/reserva", method = RequestMethod.POST)
		public ResponseEntity<?> cancelarReserva(@RequestBody Aluguel aluguel) {
		aluguel = aluguelService.atualizaStatus(aluguel, AluguelStatus.CANCELADO);
		return ResponseEntity.ok(aluguel);
	}
	
	@RequestMapping(value = "/devolverlivro", method = RequestMethod.POST)
	public ResponseEntity<?> devolverLivroAlugado(@RequestBody Aluguel aluguel) {
		aluguel = bibliotecaService.devolverLivroAlugado(aluguel);
		return ResponseEntity.ok(aluguel);
	}

}
