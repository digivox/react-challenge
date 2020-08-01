package br.com.digivox.reactchallenge.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.digivox.reactchallenge.domain.Cliente;

@RestController
@RequestMapping(value="/biblioteca")
public class BibliotecaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String addCliente(Cliente cliente) {
		return "REST está funcionando";
	}

}
