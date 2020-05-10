package com.leonardo.financascontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.financascontrol.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
