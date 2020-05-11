package com.leonardo.financascontrol.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.leonardo.financascontrol.events.RecursoCriadoEvent;
import com.leonardo.financascontrol.model.Pessoa;
import com.leonardo.financascontrol.repository.PessoaRepository;
import com.leonardo.financascontrol.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Pessoa> cadastrarPessoa (@RequestBody @Valid Pessoa pessoa, HttpServletResponse response) {
		
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
		
	}
	
	@GetMapping
	public List<Pessoa> listarPessoas () {
		
		List<Pessoa> lista = pessoaRepository.findAll();	
		return lista;	
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Pessoa>> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);
		 if (pessoa.isPresent())
			return ResponseEntity.ok(pessoa);
		else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> deletar (@PathVariable Long codigo) {
		
		Optional<Pessoa> optional = pessoaRepository.findById(codigo);
		if(optional.isPresent()) {
			pessoaRepository.deleteById(codigo);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<Pessoa> atualizar (@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);

		return ResponseEntity.ok(pessoaSalva);
	
		
	}
	
}
