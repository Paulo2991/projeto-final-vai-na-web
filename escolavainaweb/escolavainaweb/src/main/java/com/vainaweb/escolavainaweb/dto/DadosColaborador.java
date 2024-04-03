package com.vainaweb.escolavainaweb.dto;

import com.vainaweb.escolavainaweb.enums.Cargo;

import jakarta.validation.Valid;

public record DadosColaborador(String nome,String cpf,String email,Cargo cargo,@Valid EnderecoDTO endereco) {
	
}
