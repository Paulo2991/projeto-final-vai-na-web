package com.vainaweb.escolavainaweb.service;

import java.util.List;

import com.vainaweb.escolavainaweb.dto.DadosAlunos;
import com.vainaweb.escolavainaweb.dto.DadosAtualizadosAlunos;
import com.vainaweb.escolavainaweb.model.Alunos;

public interface AlunosService {
	public List<Alunos> encontarTodosOsAlunos();
	public Alunos createAlunos(DadosAlunos dados);
	public Alunos updateAlunos(Long id,DadosAtualizadosAlunos dadosAtualizadosAlunos);
	public Alunos encontrarAlunosPorId(Long id);
	public Alunos deleteAlunos(Long id);
}
