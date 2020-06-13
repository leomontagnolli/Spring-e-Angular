package com.leonardo.financascontrol.repository.lancamento;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.leonardo.financascontrol.model.Lancamento;
import com.leonardo.financascontrol.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public Page<Lancamento> filtrar (LancamentoFilter lancamento, Pageable pageable);

}
