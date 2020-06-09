package com.leonardo.financascontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.financascontrol.model.Lancamento;
import com.leonardo.financascontrol.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
