package br.com.digivox.reactchallenge.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digivox.reactchallenge.domain.Aluguel;
import br.com.digivox.reactchallenge.enums.AluguelStatus;
import br.com.digivox.reactchallenge.services.AluguelService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/aluguel")
public class AluguelResource {
	
	@Autowired
	private AluguelService aluguelService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findId(@PathVariable Integer id) throws ObjectNotFoundException {
		Aluguel aluguel = aluguelService.findById(id);
		return ResponseEntity.ok().body(aluguel);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createAluguel(@RequestBody Aluguel aluguel) {
		aluguel = aluguelService.createAluguel(aluguel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(aluguel.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/cancelar", method = RequestMethod.POST)
	public ResponseEntity<?> cancelarReserva(@RequestBody Aluguel aluguel) {
		aluguel = aluguelService.atualizaStatus(aluguel, AluguelStatus.CANCELADO);
		return ResponseEntity.ok(aluguel);
	}
	
	@RequestMapping(value = "/devolverlivro", method = RequestMethod.POST)
	public ResponseEntity<?> devolverLivroAlugado(@RequestBody Aluguel aluguel) {
		aluguel = aluguelService.devolverLivroAlugado(aluguel);
		return ResponseEntity.ok(aluguel);
	}
	
	@RequestMapping(value = "/devolucoesprevistas", method = RequestMethod.GET)
	public ResponseEntity<Page<Aluguel>> alugueisPrevistoParaDevolucao(
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="size", defaultValue = "10") Integer size) {
		Page<Aluguel> pages = aluguelService.alugueisPrevistoParaDevolucao(page, size);
		return ResponseEntity.ok(pages);
	}
	
	@RequestMapping(value = "/alugadosnasemana", method = RequestMethod.GET)
	public ResponseEntity<Page<Aluguel>> alugadosNaSemana(
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="size", defaultValue = "10") Integer size) {
		Page<Aluguel> pages = aluguelService.alugadosNaSemana(page, size);
		return ResponseEntity.ok(pages);
	}

}
