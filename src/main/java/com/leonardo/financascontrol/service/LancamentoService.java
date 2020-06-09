package com.leonardo.financascontrol.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.financascontrol.model.Lancamento;
import com.leonardo.financascontrol.model.Pessoa;
import com.leonardo.financascontrol.repository.LancamentoRepository;
import com.leonardo.financascontrol.repository.PessoaRepository;
import com.leonardo.financascontrol.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.getOne((lancamento.getPessoa().getCodigo()));
		if(pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}	
		return lancamentoRepository.save(lancamento);
	}

}
