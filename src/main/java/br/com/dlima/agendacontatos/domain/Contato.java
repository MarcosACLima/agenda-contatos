package br.com.dlima.agendacontatos.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;
 
@Validated
@Entity
@Table(name = "contato")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class Contato implements Serializable {
 
    private static final long serialVersionUID = 4048798961366546485L;
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 100)
    private String nome;
    
    @Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
    @Size(max = 25)
    private String telefone;
    
    @Email(message = "Email Address")
    @Size(max = 100)
    private String email;
    
    @Size(max = 50)
    private String endereco1;
    
    @Size(max = 50)
    private String endereco2;
    
    @Size(max = 50)
    private String endereco3;
      
    @Size(max = 20)
    private String codigo_postal;
    
    @Column(length = 4000)
    private String nota;    
}