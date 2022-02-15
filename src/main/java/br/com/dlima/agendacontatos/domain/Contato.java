package br.com.dlima.agendacontatos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;


@Validated
@Entity
@Table(name= "contato")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class Contato implements Serializable {

	private static final long serialVersionUID = 4882130256802557521L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
		
	private String telefone;
	
	private String email;
	
    private String endereco1;

    private String endereco2;

    private String endereco3;

    private String CodigoPostal;
    
    @Column(length = 4000)
    private String nota;

}
