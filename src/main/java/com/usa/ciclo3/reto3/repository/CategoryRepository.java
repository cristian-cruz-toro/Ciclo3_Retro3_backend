
package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.crud.CategoryCrudRepository;

/**
 * repositorio CRUD proyecto Cuatrimotos category
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Repository
public class CategoryRepository {
	/**
	 * importar repositorio categoria
	 */
	@Autowired
	private CategoryCrudRepository categoryCrudRepository;

	/**
	 * obtener todos los elementos de  category
	 */
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    /**
	 * obtener por id el category
	 */
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
	/**
	 * eliminar por id elemento en category
	 */
    public void deleteId(Integer id) {
    	categoryCrudRepository.deleteById(id);
    }

	/**
	 * guardar nuevo elemento en category
	 */
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    
	/**
	 * actualizar datos de category
	 */
    public Category update(Category c) {
    	return categoryCrudRepository.save(c);
	}
}
