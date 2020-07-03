package com.leonardo.financascontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.financascontrol.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	//procurar pelo nome
	public List<Categoria> findByNome(String nome);

}
