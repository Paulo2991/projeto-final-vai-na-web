package com.vainaweb.escolavainaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vainaweb.escolavainaweb.dto.DadosColaborador;
import com.vainaweb.escolavainaweb.intefaces.ColaboradoresRepository;
import com.vainaweb.escolavainaweb.model.Colaboradores;
import com.vainaweb.escolavainaweb.service.ColaboladoresService;

@Service
public class ColaboradoresServiceImpl implements ColaboladoresService {

	@Autowired
	private ColaboradoresRepository colaboradoresRepository;

	public String cadastrarColaborador(DadosColaborador dados) {
		var existente = colaboradoresRepository.findByCpf(dados.cpf());

		if (existente.isPresent()) {
			return "CPF Ja cadastrado";
		}else {
			var colaborador = new Colaboradores(dados.nome(), dados.cpf(), dados.email(), dados.cargo());
			colaboradoresRepository.save(colaborador);
		}
		
		return "Cadastrado Com Sucesso";
	}

	public List<Colaboradores> encontrarTodos() {
		return colaboradoresRepository.findAll();
	}

}
