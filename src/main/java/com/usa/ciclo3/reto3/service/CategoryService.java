/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camna
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save (Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> caux = categoryRepository.getCategory(c.getId());
            if(!caux.isPresent()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
}