package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.CategoryRepository;

/**
 * servicio CRUD proyecto Cuatrimotos category
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Service
public class CategoryService {
	/**
	 * importar repositorio categoria
	 */
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * obtener todos los elementos de  category
	 */
	public List<Category> getAll() {
		return categoryRepository.getAll();
	}

	/**
	 * obtener por id el category
	 */
	public Optional<Category> getCategory(int id) {
		return categoryRepository.getCategory(id);
	}

	/**
	 * guardar nuevo elemento en category
	 */
	public Category save(Category c) {
		if (c.getId() == null) {
			return categoryRepository.save(c);
		} else {
			Optional<Category> caux = categoryRepository.getCategory(c.getId());
			if (!caux.isPresent()) {
				return categoryRepository.save(c);
			} else {
				return c;
			}
		}
	}

	/**
	 * eliminar por id elemento en category
	 */
	public void deleteId(Integer id) {
		try {
			categoryRepository.deleteId(id);
		} catch (Exception e) {
		}
	}

	/**
	 * actualizar datos de category
	 */
	public Category update(Category c) {
		if (c.getId() != null) {
			Optional<Category> cat = categoryRepository.getCategory(c.getId());
			if (!cat.isEmpty()) {
				if (c.getName() != null) {
					cat.get().setName(c.getName());
				}
				if (c.getDescription() != null) {
					cat.get().setDescription(c.getDescription());
				}
				if (c.getQuadbikes() != null) {
					cat.get().setQuadbikes(c.getQuadbikes());
				}
				categoryRepository.save(cat.get());
				return cat.get();
			} else {
				return c;
			}
		} else {
			return c;
		}
	}
}