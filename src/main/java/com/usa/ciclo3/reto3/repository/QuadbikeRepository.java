package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Quadbike;
import com.usa.ciclo3.reto3.repository.crud.QuadbikeCrudRepository;


@Repository
public class QuadbikeRepository {

	@Autowired
	private QuadbikeCrudRepository quadbikeCrudRepository;

    public List<Quadbike> getAll(){
        return (List<Quadbike>) quadbikeCrudRepository.findAll();
    }
    
    public Optional<Quadbike> getQuadbike(int id){
        return quadbikeCrudRepository.findById(id);
    }
    
    public Quadbike save(Quadbike q){
        return quadbikeCrudRepository.save(q);
    }
    
    public void deleteId(Integer id) {
    	quadbikeCrudRepository.deleteById(id);
    }
    
    public Quadbike update(Quadbike q) {
    	return quadbikeCrudRepository.save(q);
	}
}
