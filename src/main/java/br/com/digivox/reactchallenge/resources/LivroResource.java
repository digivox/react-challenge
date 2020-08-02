package br.com.digivox.reactchallenge.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digivox.reactchallenge.domain.Livro;
import br.com.digivox.reactchallenge.services.LivroService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/livro")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping(value = "/find/{livroId}", method = RequestMethod.GET)
	public ResponseEntity<?> findByLivroId(@PathVariable Integer livroId) throws ObjectNotFoundException {
		Livro livro = livroService.findByLivroId(livroId);
		return ResponseEntity.ok().body(livro);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addLivro(@RequestBody Livro livro) {
		livro = livroService.addLivro(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
