package com.cmendes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cmendes.cursomc.domain.Categoria;
import com.cmendes.cursomc.domain.Produto;
import com.cmendes.cursomc.repositories.CategoriaRepository;
import com.cmendes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impresora", 750.00);
		Produto p3 = new Produto(null, "Mouse", 59.99);
		
		categoria.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		categoria2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(categoria));
		p2.getCategorias().addAll(Arrays.asList(categoria,categoria2));
		p3.getCategorias().addAll(Arrays.asList(categoria));
		
		categoriaRepo.saveAll(Arrays.asList(categoria,categoria2));
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
	}

}
