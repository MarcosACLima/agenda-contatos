package br.com.dlima.agendacontatos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.dlima.agendacontatos.domain.Contato;
import br.com.dlima.agendacontatos.exception.BadResourceException;
import br.com.dlima.agendacontatos.exception.ResourceAlreadyExistsException;
import br.com.dlima.agendacontatos.exception.ResourceNotFoundException;
import br.com.dlima.agendacontatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	private boolean existsById(Long id) {
		return contatoRepository.existsById(id);
	}

	public Contato findById(Long id) throws ResourceNotFoundException {
		Contato contato = contatoRepository.findById(id).orElse(null);
		if (contato == null) {
			throw new ResourceNotFoundException("Não é possível encontrar o contato com o ID: " + id);
		} else
			return contato;
	}
	
	public List<Contato> findAll(int pageNumber, int rowPerPage) {
		List<Contato> contatos = new ArrayList<>();
		Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, Sort.by("id").ascending());
		contatoRepository.findAll(sortedByIdAsc).forEach(contatos::add);
		return contatos;
	}

	public Contato save(Contato contato) 
			throws BadResourceException, ResourceAlreadyExistsException {
		if(!StringUtils.isEmpty(contato.getNome())) {
			
		}
	}

}
