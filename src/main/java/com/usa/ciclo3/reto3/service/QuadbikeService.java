/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Quadbike;
import com.usa.ciclo3.reto3.repository.QuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camna
 */

@Service
public class QuadbikeService {
    @Autowired
    private QuadbikeRepository quadbikeRepository;
    
    public List<Quadbike> getAll(){
        return quadbikeRepository.getAll();
    }
    
    public Optional<Quadbike> getQuadbike(int id){
        return quadbikeRepository.getQuadbike(id);
    }
    
    public Quadbike save (Quadbike q){
        if(q.getId()==null){
            return quadbikeRepository.save(q);
        }else{
            Optional<Quadbike> qaux = quadbikeRepository.getQuadbike(q.getId());
            if(!qaux.isPresent()){
                return quadbikeRepository.save(q);
            }else{
                return q;
            }
        }
    }
}
