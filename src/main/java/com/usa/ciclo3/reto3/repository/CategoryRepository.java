
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
	private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public void deleteId(Integer id) {
    	categoryCrudRepository.deleteById(id);
    }
    
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    
    public Category update(Category c) {
    	return categoryCrudRepository.save(c);
	}
}
