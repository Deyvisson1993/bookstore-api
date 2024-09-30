package com.deyvisson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyvisson.bookstore.domain.Categoria;
import com.deyvisson.bookstore.domain.Livro;
import com.deyvisson.bookstore.repositories.LivroRepository;
import com.deyvisson.bookstore.service.exceptions.ObjectNotFoundExeception;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> fidAll(Integer id_cat) {
		categoriaService.findBayId(id_cat);

		return repository.findAllByCategoria(id_cat);

	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id); // Verifica se o livro exite
		updateData(newObj, obj);

		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {

		if (obj.getTitulo() != null) {
			newObj.setTitulo(obj.getTitulo());
		}

		if (obj.getNome_autor() != null) {
			newObj.setNome_autor(obj.getNome_autor());
		}

		if (obj.getTexto() != null) {
			newObj.setTexto(obj.getTexto());
		}
	}

	public Livro create(Integer id_cat, Livro obj) {
		
		obj.setId(null);
		Categoria categoria = categoriaService.findBayId(id_cat);
		
		obj.setCategoria(categoria);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		
		Livro obj = findById(id);
		repository.delete(obj);
	}

}
