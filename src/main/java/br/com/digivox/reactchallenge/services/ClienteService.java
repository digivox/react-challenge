package br.com.digivox.reactchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digivox.reactchallenge.domain.Cliente;
import br.com.digivox.reactchallenge.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);	 
	}
	
}
