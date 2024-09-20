package com.deyvisson.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyvisson.bookstore.domain.Livro;
import com.deyvisson.bookstore.repositories.LivroRepository;
import com.deyvisson.bookstore.service.exceptions.ObjectNotFoundExeception;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Livro.class.getName()));
	}

}
