package com.usa.ciclo3.reto3.service;


import com.usa.ciclo3.reto3.model.Quadbike;
import com.usa.ciclo3.reto3.repository.QuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * servicio CRUD proyecto Cuatrimotos Quadbike
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Service
public class QuadbikeService {
	
	/**
	 * importar repositorio Quadbike
	 */
    @Autowired
    private QuadbikeRepository quadbikeRepository;
    
	/**
	 * obtener todos los elementos de Quadbike
	 */
    public List<Quadbike> getAll(){
        return quadbikeRepository.getAll();
    }
    
	/**
	 * obtener por id el Quadbike
	 */
    public Optional<Quadbike> getQuadbike(int id){
        return quadbikeRepository.getQuadbike(id);
    }
    
	/**
	 * guardar nuevo elemento en Quadbike
	 */
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
    
	/**
	 * eliminar por id elemento en Quadbike
	 */
    public  void deleteId(Integer id) {
    	try {			
    		quadbikeRepository.deleteId(id);
    	} catch (Exception e) {
    	}
    }
    
	/**
	 * actualizar datos de Quadbike
	 */
    public  Quadbike update(Quadbike q) {
    	if(q.getId()!=null) {
			Optional<Quadbike> qua= quadbikeRepository.getQuadbike(q.getId());
			if(!qua.isEmpty()){
                if(q.getName()!=null){
                    qua.get().setName(q.getName());
                }
                if(q.getBrand()!=null){
                    qua.get().setBrand(q.getBrand());
                }
                if(q.getYear()!=null){
                    qua.get().setYear(q.getYear());
                }       
                if(q.getDescription()!=null){
                    qua.get().setDescription(q.getDescription());
                }
                if(q.getCategory()!=null){
                    qua.get().setCategory(q.getCategory());
                }
                if(q.getMessages()!=null){
                    qua.get().setMessages(q.getMessages());
                }
                if(q.getReservations()!=null){
                    qua.get().setReservations(q.getReservations());
                }
                quadbikeRepository.save(qua.get());
                return qua.get();
			}else{
                return q;
            }	
		}else{
            return q;
        }
    }
}
