package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.crud.ClientCrudRepository;

/**
 * repositorio CRUD proyecto Cuatrimotos client
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Repository
public class ClientRepository {
	
	/**
	 * importar repositorio client
	 */
	@Autowired
	private ClientCrudRepository clientCrudRepository;
	
	/**
	 * obtener todos los elementos de  client
	 */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    /**
 	 * obtener por id el client
 	 */
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
	/**
	 * guardar nuevo elemento en client
	 */
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }
    
    /**
     * eliminar por id elemento en client
     */
    public void deleteId(Integer id) {
    	clientCrudRepository.deleteById(id);
    }
}
