package com.vainaweb.escolavainaweb.intefaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vainaweb.escolavainaweb.model.Colaboradores;

@Repository
public interface ColaboradoresRepository extends JpaRepository<Colaboradores,Long> {
	
}
