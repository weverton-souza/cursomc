package com.weverton.cursomc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weverton.cursomc.domains.Categoria;
import com.weverton.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRep;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
	
		List<Categoria> listCategoria = Arrays.asList(
				new Categoria(null, "Informática"),
				new Categoria(null, "Escritório"),
				new Categoria(null, "Periféricos"),
				new Categoria(null, "Notebooks")
				);
		
		categoriaRep.save(listCategoria);
		
	}
	
}
