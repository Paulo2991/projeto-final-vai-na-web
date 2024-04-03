package com.vainaweb.escolavainaweb.intefaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vainaweb.escolavainaweb.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos,Long> {
	
}
