package com.leonardo.financascontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.financascontrol.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	public List<Pessoa> findByNome(String nome);
}
