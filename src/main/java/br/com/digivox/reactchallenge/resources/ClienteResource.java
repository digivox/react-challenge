package br.com.digivox.reactchallenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digivox.reactchallenge.domain.Cliente;
import br.com.digivox.reactchallenge.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.addCliente(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/listall", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		List<Cliente> clientes = clienteService.listAll();
		return ResponseEntity.ok(clientes);
	}

}
