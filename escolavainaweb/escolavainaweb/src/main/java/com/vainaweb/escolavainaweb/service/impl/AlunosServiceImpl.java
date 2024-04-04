package com.vainaweb.escolavainaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vainaweb.escolavainaweb.dto.DadosAlunos;
import com.vainaweb.escolavainaweb.dto.DadosAtualizadosAlunos;
import com.vainaweb.escolavainaweb.exceptions.ExceptionsManager;
import com.vainaweb.escolavainaweb.intefaces.AlunosRepository;
import com.vainaweb.escolavainaweb.model.Alunos;
import com.vainaweb.escolavainaweb.model.Endereco;
import com.vainaweb.escolavainaweb.service.AlunosService;

@Service
public class AlunosServiceImpl implements AlunosService {

	@Autowired
	private AlunosRepository alunosRepository;

	public List<Alunos> encontarTodosOsAlunos() {
		return alunosRepository.findAll(); // SELECT * FROM tb_aluno
	}
	
	public Alunos encontrarAlunosPorId(Long id) {
		Alunos alunos = alunosRepository.findById(id)
				.orElseThrow(() -> new ExceptionsManager("Alunos não cadastrados"));
		return alunos;
	}

	public Alunos createAlunos(DadosAlunos dados) {
		Alunos alunos = new Alunos(dados.nome(), dados.email(), dados.cpf(), dados.curso(), dados.telefone(),dados.endereco());
		var cpfExistente = alunosRepository.findByCpf(dados.cpf());
		var emailExistente = alunosRepository.findByEmail(dados.email());

		if (cpfExistente.isPresent()) {
			throw new ExceptionsManager("CPF Já cadastrado!");
		}

		if (emailExistente.isPresent()) {
			throw new ExceptionsManager("Email já cadastrado!");
		}else {
			this.alunosRepository.save(alunos);
		}
		
		return alunos;
	}

	public Alunos updateAlunos(Long id, DadosAtualizadosAlunos dadosAtualizadosAlunos) {
		Alunos alunos = alunosRepository.findById(id)
				.orElseThrow(() -> new ExceptionsManager("Alunos não cadastrados"));
		alunos.setNome(dadosAtualizadosAlunos.nome());
		alunos.setTelefone(dadosAtualizadosAlunos.telefone());
		alunos.setCurso(dadosAtualizadosAlunos.curso());
		alunos.setEndereco(new Endereco(dadosAtualizadosAlunos.endereco().cep(), dadosAtualizadosAlunos.endereco().logradouro(),
				dadosAtualizadosAlunos.endereco().bairro(),dadosAtualizadosAlunos.endereco().cidade(), 
				dadosAtualizadosAlunos.endereco().numero(),dadosAtualizadosAlunos.endereco().complemento(), dadosAtualizadosAlunos.endereco().uf()));
		return this.alunosRepository.save(alunos);
	}
	
	public Alunos deleteAlunos(Long id) {
		Alunos alunos = alunosRepository.findById(id)
				.orElseThrow(() -> new ExceptionsManager("Aluno não cadastrado com esse " + id));
		this.alunosRepository.deleteById(id);
		return alunos;
	}
}
