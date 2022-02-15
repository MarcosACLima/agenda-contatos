package br.com.dlima.agendacontatos.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.dlima.agendacontatos.domain.Contato;

public interface ContatoRepository
		extends PagingAndSortingRepository<Contato, Long>, JpaSpecificationExecutor<Contato> {
}
