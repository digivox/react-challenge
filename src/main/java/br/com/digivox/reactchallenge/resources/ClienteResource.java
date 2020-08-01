package br.com.digivox.reactchallenge.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.digivox.reactchallenge.domain.Cliente;
import br.com.digivox.reactchallenge.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@ResponseBody
	@RequestMapping(value = "/addcliente")
	public Cliente addCliente(Cliente cliente) {
		return clienteService.addCliente(cliente);
	}

}
