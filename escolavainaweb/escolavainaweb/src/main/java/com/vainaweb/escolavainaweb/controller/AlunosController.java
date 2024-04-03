package com.vainaweb.escolavainaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vainaweb.escolavainaweb.dto.DadosAlunos;
import com.vainaweb.escolavainaweb.model.Alunos;
import com.vainaweb.escolavainaweb.service.impl.AlunosServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

	@Autowired
	private AlunosServiceImpl alunosService;

	@GetMapping
	public List<Alunos> listeTodosAlunos() {
		return alunosService.encontarTodosOsAlunos();
	}

	@PostMapping
	public String cadastrarAluno(@RequestBody DadosAlunos dadosAlunos) {
		alunosService.cadastrar(dadosAlunos);
		return "ok";
	}

}
