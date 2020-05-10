package com.leonardo.financascontrol.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.leonardo.financascontrol.model.Pessoa;
import com.leonardo.financascontrol.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Pessoa pessoaAtualizar (Long codigo, Pessoa pessoa) {
	
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
		
		if(pessoaSalva.isPresent()) {
			BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
			
			return pessoaRepository.save(pessoaSalva.get());
			
		}else {
			throw new EmptyResultDataAccessException(1);
		}
	
		
	
		
	}

}
