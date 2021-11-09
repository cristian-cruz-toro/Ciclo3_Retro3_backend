package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Quadbike;
import com.usa.ciclo3.reto3.repository.crud.QuadbikeCrudRepository;

/**
 * repositorio CRUD proyecto Cuatrimotos Quadbike
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Repository
public class QuadbikeRepository {

	/**
	 * importar repositorio Quadbike
	 */
	@Autowired
	private QuadbikeCrudRepository quadbikeCrudRepository;

	/**
	 * obtener todos los elementos de  Quadbike
	 */
    public List<Quadbike> getAll(){
        return (List<Quadbike>) quadbikeCrudRepository.findAll();
    }
    
    /**
 	 * obtener por id el Quadbike
 	 */
    public Optional<Quadbike> getQuadbike(int id){
        return quadbikeCrudRepository.findById(id);
    }
    
	/**
	 * guardar nuevo elemento en Quadbike
	 */
    public Quadbike save(Quadbike q){
        return quadbikeCrudRepository.save(q);
    }
    
    /**
     * eliminar por id elemento en Quadbike
     */
    public void deleteId(Integer id) {
    	quadbikeCrudRepository.deleteById(id);
    }
    
	/**
	 * actualizar datos de Quadbike
	 */
    public Quadbike update(Quadbike q) {
    	return quadbikeCrudRepository.save(q);
	}
}
