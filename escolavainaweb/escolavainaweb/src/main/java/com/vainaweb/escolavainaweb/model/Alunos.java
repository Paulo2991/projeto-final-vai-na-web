package com.vainaweb.escolavainaweb.model;

import org.hibernate.validator.constraints.br.CPF;

import com.vainaweb.escolavainaweb.enums.Curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_alunos")
public class Alunos {
	
	@Id
    private Long id;

    private String nome;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @CPF
    @Column(unique = true, nullable = false)
    private String cpf;

    private Curso curso;

    private String telefone;

    @Embedded
    private Endereco endereco;
    
    public Alunos(String nome, String email, String cpf, Curso curso, String telefone) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.curso = curso;
        this.telefone = telefone;
    }
	
}
