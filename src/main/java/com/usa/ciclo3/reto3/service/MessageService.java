package com.usa.ciclo3.reto3.service;


import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * servicio CRUD proyecto Cuatrimotos message
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Service
public class MessageService {
	
	/**
	 * importar repositorio message
	 */
    @Autowired
    private MessageRepository messageRepository;
    
	/**
	 * obtener todos los elementos de message
	 */
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
	/**
	 * obtener por id el message
	 */
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
	/**
	 * guardar nuevo elemento en message
	 */
    public Message save (Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> qaux = messageRepository.getMessage(m.getIdMessage());
            if(!qaux.isPresent()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }
    
	/**
	 * eliminar por id elemento en message
	 */
    public  void deleteId(Integer id) {
    	try {			
    		messageRepository.deleteId(id);
    	} catch (Exception e) {
    	}
    }
    
	/**
	 * actualizar datos de message
	 */
    public  Message update(Message c) {
    	if(c.getIdMessage()!=null) {
			Optional<Message> men= messageRepository.getMessage(c.getIdMessage());
			if(!men.isEmpty()){
                if(c.getMessageText()!=null){
                    men.get().setMessageText(c.getMessageText());
                }
                if(c.getQuadbike()!=null){
                    men.get().setQuadbike(c.getQuadbike());
                }
                if(c.getClient()!=null){
                    men.get().setClient(c.getClient());
                }
                messageRepository.save(men.get());
                return men.get();
			}else{
                return c;
            }	
		}else{
            return c;
        }
    }
}
