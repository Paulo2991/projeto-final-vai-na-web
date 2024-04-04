package com.vainaweb.escolavainaweb.intefaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vainaweb.escolavainaweb.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {
	Optional<Alunos> findById(Long id);
	Optional<Alunos> findByCpf(String cpf);
	Optional<Alunos> findByEmail(String email);
}
