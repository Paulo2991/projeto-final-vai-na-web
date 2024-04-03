package com.vainaweb.escolavainaweb.service;

import java.util.List;

import com.vainaweb.escolavainaweb.dto.DadosAlunos;
import com.vainaweb.escolavainaweb.model.Alunos;

public interface AlunosService {
	public List<Alunos> encontarTodosOsAlunos();
	public void cadastrar(DadosAlunos dados);
}
