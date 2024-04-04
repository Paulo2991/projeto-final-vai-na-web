package com.vainaweb.escolavainaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vainaweb.escolavainaweb.dto.DadosColaborador;
import com.vainaweb.escolavainaweb.exceptions.ExceptionsManager;
import com.vainaweb.escolavainaweb.intefaces.ColaboradoresRepository;
import com.vainaweb.escolavainaweb.model.Colaboradores;
import com.vainaweb.escolavainaweb.service.ColaboladoresService;

@Service
public class ColaboradoresServiceImpl implements ColaboladoresService {

	@Autowired
	private ColaboradoresRepository colaboradoresRepository;

	public Colaboradores cadastrarColaborador(DadosColaborador dados) {
		Colaboradores colaboladores = new Colaboradores(dados.nome(), dados.email(), dados.cpf(), dados.cargo(),
				dados.endereco());
		var cpfExistente = colaboradoresRepository.findByCpf(dados.cpf());
		var emailExistente = colaboradoresRepository.findByEmail(dados.email());

		if (cpfExistente.isPresent()) {
			throw new ExceptionsManager("CPF Já cadastrado!");
		}

		if (emailExistente.isPresent()) {
			throw new ExceptionsManager("Email já cadastrado!");

		} else {
			this.colaboradoresRepository.save(colaboladores);
		}

		return colaboladores;
	}

	public List<Colaboradores> encontrarTodos() {
		return colaboradoresRepository.findAll();
	}
	
}
