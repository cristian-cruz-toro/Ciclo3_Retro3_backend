package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.crud.MessageCrudRepository;

/**
 * repositorio CRUD proyecto Cuatrimotos message
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Repository
public class MessageRepository {
	
	/**
	 * importar repositorio message
	 */
	@Autowired
	private MessageCrudRepository messageCrudRepository;

	/**
	 * obtener todos los elementos de  message
	 */
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    /**
 	 * obtener por id el message
 	 */
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    /**
     * eliminar por id elemento en message
     */
    public void deleteId(Integer id) {
    	messageCrudRepository.deleteById(id);
    }
    
	/**
	 * guardar nuevo elemento en message
	 */
    public Message save(Message m){
        return messageCrudRepository.save(m);
    }
    
	/**
	 * actualizar datos de message
	 */
    public Message update(Message c) {
    	return messageCrudRepository.save(c);
    }
}
