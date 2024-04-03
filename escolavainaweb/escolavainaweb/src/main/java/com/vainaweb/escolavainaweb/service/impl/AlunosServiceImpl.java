package com.vainaweb.escolavainaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vainaweb.escolavainaweb.dto.DadosAlunos;
import com.vainaweb.escolavainaweb.intefaces.AlunosRepository;
import com.vainaweb.escolavainaweb.model.Alunos;
import com.vainaweb.escolavainaweb.service.AlunosService;

@Service
public class AlunosServiceImpl implements AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;

	public List<Alunos> encontarTodosOsAlunos() {
		return alunosRepository.findAll(); // SELECT * FROM tb_aluno
	}

	public void cadastrar(DadosAlunos dados) {
		var aluno = new Alunos(dados.nome(), dados.email(), dados.cpf(), dados.curso(), dados.telefone());
		alunosRepository.save(aluno); // INSERT INTO tb_aluno (nome, email, cpf, curso, telefone) VALUES (dados.nome,					// dados.email, dados.cpf, dados.curso, dados.telefone)
	}
}
