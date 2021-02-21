package br.com.agenda.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.domain.Contato;
import br.com.agenda.exception.ContatoNotFoundException;
import br.com.agenda.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	public List<Contato> findAllContato() {
		return contatoRepository.findAll();
	}

	public Contato addContato(Contato contato) {
		contato.setCode(UUID.randomUUID().toString());

		return contatoRepository.save(contato);
	}

	public Contato findByIdContato(Long id) {
		return contatoRepository.findById(id)
				.orElseThrow(() -> new ContatoNotFoundException("Contato id: " + id + " não foi encontrado."));
	}

	public void deleteContato(Long id) {
		contatoRepository.deleteById(id);
	}
	
	public Contato updateContato(Contato contato) {
		return contatoRepository.save(contato);
	}

}
