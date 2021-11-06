package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save (Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> caux = clientRepository.getClient(c.getIdClient());
            if(!caux.isPresent()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    public  void deleteId(Integer id) {
    	try {			
    		clientRepository.deleteId(id);
    	} catch (Exception e) {
    	}
    }
    
    public  Client update(Client c) {
             return clientRepository.save(c);
    }
}
