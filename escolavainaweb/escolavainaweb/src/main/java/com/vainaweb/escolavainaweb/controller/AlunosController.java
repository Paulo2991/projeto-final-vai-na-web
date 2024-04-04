package com.vainaweb.escolavainaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vainaweb.escolavainaweb.dto.DadosAlunos;
import com.vainaweb.escolavainaweb.dto.DadosAtualizadosAlunos;
import com.vainaweb.escolavainaweb.exceptions.ExceptionsManager;
import com.vainaweb.escolavainaweb.model.Alunos;
import com.vainaweb.escolavainaweb.service.impl.AlunosServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

	@Autowired
	private AlunosServiceImpl alunosService;
	

	@GetMapping
	public List<Alunos> listeTodosAlunos() {
		return alunosService.encontarTodosOsAlunos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarTodosAlunosId(@PathVariable Long id) {
		try {
			Alunos alunos = alunosService.encontrarAlunosPorId(id);
			return ResponseEntity.ok(alunos);
		}catch(ExceptionsManager e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrarAluno(@Valid @RequestBody DadosAlunos dadosAlunos) {
		try {
			Alunos alunos = alunosService.createAlunos(dadosAlunos);
			return ResponseEntity.status(HttpStatus.CREATED).body(alunos);
		}catch(ExceptionsManager e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAluno(@PathVariable Long id,
			@Validated @RequestBody DadosAtualizadosAlunos dadosAtualizadosAluno) {
		try {
			Alunos alunos = alunosService.updateAlunos(id, dadosAtualizadosAluno);
			return ResponseEntity.ok(alunos);
		}catch(ExceptionsManager e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirAlunos(@PathVariable Long id) {
		try {
			Alunos alunos = alunosService.deleteAlunos(id);
			return ResponseEntity.ok("Aluno deletado com esse id: " + alunos.getId());
		}catch(ExceptionsManager e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
		}
	}

}
