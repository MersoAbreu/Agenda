package br.com.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.domain.Contato;
import br.com.agenda.service.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public List<Contato> findAll() {
		return contatoService.findAllContato();
	}

	@PostMapping
	public ResponseEntity<Contato> addContato(@RequestBody Contato contato) {
		Contato contatos = contatoService.addContato(contato);
		return new ResponseEntity<>(contatos, HttpStatus.CREATED);
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Contato> findByIdContato(@PathVariable Long id) {
		Contato contatos = contatoService.findByIdContato(id);
		return new ResponseEntity<>(contatos, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Contato> updateContato(@RequestBody Contato contato){
		Contato updateContato = contatoService.updateContato(contato);
		return new ResponseEntity<>(updateContato, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Contato> deleteContato(@PathVariable ("id") Long id){
		contatoService.deleteContato(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
}
