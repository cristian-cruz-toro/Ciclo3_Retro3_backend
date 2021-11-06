package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
	@Autowired
	private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }
    
    public void deleteId(Integer id) {
    	clientCrudRepository.deleteById(id);
    }
    
    public Client update(Client c) {
    	return clientCrudRepository.save(c);
	}
}
