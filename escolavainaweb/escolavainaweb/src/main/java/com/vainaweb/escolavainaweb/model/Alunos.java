package com.vainaweb.escolavainaweb.model;

import org.hibernate.validator.constraints.br.CPF;

import com.vainaweb.escolavainaweb.dto.EnderecoDTO;
import com.vainaweb.escolavainaweb.enums.Curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_alunos")
public class Alunos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotEmpty
    private String nome;

    @Email
    @Column(unique = true, nullable = false)
    @NotEmpty
    private String email;

    @CPF
    @Column(unique = true, nullable = false, length = 11)
    @NotEmpty
    private String cpf;

    @NotEmpty
    private Curso curso;

    @NotEmpty
    private String telefone;

    @Embedded
    @NotEmpty
    private Endereco endereco;
    
    public Alunos(String nome, String email, String cpf, Curso curso, String telefone, EnderecoDTO endereco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.curso = curso;
        this.telefone = telefone;
        this.endereco = new Endereco(endereco.cep(), endereco.logradouro(),
				endereco.bairro(),endereco.cidade(), 
				endereco.numero(),endereco.complemento(), endereco.uf());    
        }
	
}
