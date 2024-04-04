package com.vainaweb.escolavainaweb.service;

import java.util.List;

import com.vainaweb.escolavainaweb.dto.DadosColaborador;
import com.vainaweb.escolavainaweb.model.Colaboradores;

public interface ColaboladoresService {
	public Colaboradores cadastrarColaborador(DadosColaborador dados);
	public List<Colaboradores> encontrarTodos();
}
