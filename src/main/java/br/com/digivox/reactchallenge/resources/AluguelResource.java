package br.com.digivox.reactchallenge.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.digivox.reactchallenge.domain.Aluguel;
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

}
