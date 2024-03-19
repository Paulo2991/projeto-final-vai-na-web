package com.vainaweb.escolavainaweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Colaboradores {

	@Id
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String cargo;
}	
