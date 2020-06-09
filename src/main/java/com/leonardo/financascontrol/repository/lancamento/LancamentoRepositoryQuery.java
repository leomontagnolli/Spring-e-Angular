package com.leonardo.financascontrol.repository.lancamento;

import java.util.List;

import com.leonardo.financascontrol.model.Lancamento;
import com.leonardo.financascontrol.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar (LancamentoFilter lancamento);

}
