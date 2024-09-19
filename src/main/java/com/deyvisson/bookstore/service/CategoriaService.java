package com.deyvisson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyvisson.bookstore.domain.Categoria;
import com.deyvisson.bookstore.dtos.CategoriaDTO;
import com.deyvisson.bookstore.repositories.CategoriaRepository;
import com.deyvisson.bookstore.service.exceptions.ObjectNotFoundExeception;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findBayId(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		
		Categoria obj = findBayId(id);
		
		if (objDto.getNome() != null)
			obj.setNome(objDto.getNome());
		if (objDto.getDescricao() != null)
			obj.setDescricao(objDto.getDescricao());
		
		return categoriaRepository.save(obj);
	}
}