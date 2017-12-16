package com.weverton.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weverton.cursomc.domains.Categoria;
import com.weverton.cursomc.repositories.CategoriaRepository;

/**
 * @author weverton
 *
 *
 */

@Service
public class CategoriaService {
	
	@Autowired// Anotação: Usada para intanciar automaticamente a depedência, através do mecânismo de injeção de depedência ou inversão
			// de controle.
	CategoriaRepository categoriaRep;
	
	public Categoria buscar(final Integer id) {
		
		Categoria obj = categoriaRep.findOne(id);
		
		return obj;
	}
}
