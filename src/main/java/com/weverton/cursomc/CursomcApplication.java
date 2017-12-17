package com.weverton.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weverton.cursomc.domains.Categoria;
import com.weverton.cursomc.domains.Cidade;
import com.weverton.cursomc.domains.Cliente;
import com.weverton.cursomc.domains.Endereco;
import com.weverton.cursomc.domains.Estado;
import com.weverton.cursomc.domains.Produto;
import com.weverton.cursomc.enums.TipoCliente;
import com.weverton.cursomc.repositories.CategoriaRepository;
import com.weverton.cursomc.repositories.CidadeRepository;
import com.weverton.cursomc.repositories.ClienteRepository;
import com.weverton.cursomc.repositories.EnderecoRepository;
import com.weverton.cursomc.repositories.EstadoRepository;
import com.weverton.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRep;
	@Autowired
	ProdutoRepository produtoRep;
	@Autowired
	EstadoRepository estadoRep;
	@Autowired
	CidadeRepository cidadeRep;
	@Autowired
	ClienteRepository clienteRep;
	@Autowired
	EnderecoRepository enderecoRep;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Impressora", 2.000);
		Produto p2 = new Produto(null, "Computador", 800.00);
		Produto p3 = new Produto(null, "Mouse", 40.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		Cliente cli1 = new Cliente(null, "Maria", "Maria@gmail.com", "12345678900", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("9.9999-9999", "8.8888-8888"));
		
		Endereco e1 = new Endereco(null, "Rua 0", "000", "Casa", "Bairro Feliz", "000-0000-00", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua 1", "111", "Casa", "Bairro Feliz", "111-1111-11", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRep.save(Arrays.asList(cat1, cat2));
		produtoRep.save(Arrays.asList(p1,p2,p3));
		estadoRep.save(Arrays.asList(est1, est2));
		cidadeRep.save(Arrays.asList(c1, c2, c3));
		clienteRep.save(Arrays.asList(cli1));
		enderecoRep.save(Arrays.asList(e1, e2));
		
		
	}
	
}
