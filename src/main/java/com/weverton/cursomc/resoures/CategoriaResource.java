package com.weverton.cursomc.resoures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weverton.cursomc.domains.Categoria;
import com.weverton.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired// Anotação: Usada para intanciar automaticamente a depedência, através do mecânismo de injeção de depedência ou inversão
	// de controle.
	CategoriaService categoriaServ;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable final Integer id) {
		//ResponseEntity: Tipo especial do Spring que encapsula várias informações de uma resposta Http para um serviço Rest.
		
		Categoria cat = categoriaServ.buscar(id);
		
		return ResponseEntity.ok().body(cat);
	}
}
