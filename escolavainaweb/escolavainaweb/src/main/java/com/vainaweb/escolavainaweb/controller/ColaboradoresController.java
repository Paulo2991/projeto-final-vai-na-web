package com.vainaweb.escolavainaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vainaweb.escolavainaweb.dto.DadosAtualizadosColaboradores;
import com.vainaweb.escolavainaweb.dto.DadosColaborador;
import com.vainaweb.escolavainaweb.intefaces.ColaboradoresRepository;
import com.vainaweb.escolavainaweb.model.Colaboradores;
import com.vainaweb.escolavainaweb.service.impl.ColaboradoresServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboladores")
public class ColaboradoresController {
	
	@Autowired
	private ColaboradoresServiceImpl colaboradoresService;
	
	@Autowired
	private ColaboradoresRepository colaboradoresRepository;
	
	@PostMapping
	public ResponseEntity<String> cadastrarColaboradores(@RequestBody DadosColaborador dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(colaboradoresService.cadastrarColaborador(dados));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Colaboradores> listarColaboradoresPorId(@PathVariable Long id) {
		return colaboradoresRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping
	public List<Colaboradores> encontrarTodosOsColaboradores(){
		return colaboradoresService.encontrarTodos();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarColaboradores(@PathVariable Long id, @RequestBody @Valid DadosAtualizadosColaboradores dadosAtualizadosColaboradores) {
		var colaborador = colaboradoresRepository.getReferenceById(id);
		colaborador.atualizarInfo(dadosAtualizadosColaboradores);
		colaboradoresRepository.save(colaborador);
		return ResponseEntity.status(HttpStatus.OK).body("Dados Atualizados");
	}
	
	@DeleteMapping("/{id}")
	public String deletarColaboradores(@PathVariable Long id) {
		colaboradoresRepository.deleteById(id);
		return "Deletado Com Sucesso:";
	}
}
