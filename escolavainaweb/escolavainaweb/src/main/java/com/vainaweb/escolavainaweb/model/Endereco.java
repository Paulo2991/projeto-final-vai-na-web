package com.vainaweb.escolavainaweb.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {
	private String cep;
	private String logadouro;
	private String bairro;
	private String cidade;
	private Integer numero;
	private String complemento;
}
