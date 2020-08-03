package br.com.digivox.reactchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {
	
	@Autowired
	private ReservaService reservaService;

	public void devolverLivro(String reservaOuAluguelInfo) {
		
		System.out.println(reservaOuAluguelInfo);
		
	}

}
