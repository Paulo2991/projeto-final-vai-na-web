package com.vainaweb.escolavainaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vainaweb.escolavainaweb.dto.DadosColaborador;
import com.vainaweb.escolavainaweb.intefaces.ColaboradoresRepository;
import com.vainaweb.escolavainaweb.model.Colaboradores;
import com.vainaweb.escolavainaweb.service.impl.ColaboradoresServiceImpl;

@RestController
@RequestMapping("/colaboladores")
public class ColaboradoresController {
	
	@Autowired
	private ColaboradoresServiceImpl colaboradoresService;
	
	@Autowired
	private ColaboradoresRepository colaboradoresRepository;
	
	@PostMapping
	public ResponseEntity<String> cadastrarColaborador(@RequestBody DadosColaborador dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(colaboradoresService.cadastrarColaborador(dados));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Colaboradores> listarColaboradorPorId(@PathVariable Long id) {
		return colaboradoresRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping
	public List<Colaboradores> encontrarTodosOsColaboradores(){
		return colaboradoresService.encontrarTodos();
	}
	
}
