package com.vainaweb.escolavainaweb.model;

import org.hibernate.validator.constraints.br.CPF;

import com.vainaweb.escolavainaweb.dto.DadosAtualizadosColaboradores;
import com.vainaweb.escolavainaweb.dto.EnderecoDTO;
import com.vainaweb.escolavainaweb.enums.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_colaboradores")
public class Colaboradores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@CPF
	@Column(unique = true)
	private String cpf;
	
	@Email
	@Column(unique = true)
	private String email;
	
	private Cargo cargo;
	
	@Embedded
	private Endereco endereco;
	
	public Colaboradores(String nome,String email,String cpf,Cargo cargo, @Valid EnderecoDTO endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
		this.endereco = new Endereco(endereco.cep(), endereco.logradouro(),
				endereco.bairro(),endereco.cidade(), 
				endereco.numero(),endereco.complemento(), endereco.uf());		
	}
	
	public void atualizarInfo(@Valid DadosAtualizadosColaboradores dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;
		this.email = dados.email()!= null ? dados.email() : this.email;
	}
}	
