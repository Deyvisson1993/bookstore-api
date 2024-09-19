package com.deyvisson.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyvisson.bookstore.domain.Categoria;
import com.deyvisson.bookstore.domain.Livro;
import com.deyvisson.bookstore.repositories.CategoriaRepository;
import com.deyvisson.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void intanciaBaseDados() {

		Categoria cat1 = new Categoria(null, "Informatica", "LIvro de TI");
		Categoria cat2 = new Categoria(null, "Literatura", "LIvro da vida");

		Livro l1 = new Livro(null, "Clean Code", "Deyvisson Autor", "texto texto texto ", cat1);
		Livro l2 = new Livro(null, "Livro 1", "Autor Lirico", "asdasdasfasf", cat2);

		
		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));

		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		this.livroRepository.saveAll(Arrays.asList(l1,l2));
	}
}
