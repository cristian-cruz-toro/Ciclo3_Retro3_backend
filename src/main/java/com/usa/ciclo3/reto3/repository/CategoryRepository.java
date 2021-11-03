/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.crud.CategoryCrudRepository;


@Repository
public class CategoryRepository {
	@Autowired
	private CategoryCrudRepository CategoryCrudRepository;

	public List<Category> getAll() {
		return (List<Category>) CategoryCrudRepository.findAll();
	}

	public Optional<Category> getCategory(int id) {
		return CategoryCrudRepository.findById(id);
	}

	public Category save(Category c) {
		return CategoryCrudRepository.save(c);
	}
}
