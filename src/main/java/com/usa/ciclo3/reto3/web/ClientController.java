package com.usa.ciclo3.reto3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.service.ClientService;

/**
 * controllador CRUD proyecto Cuatrimotos Cliente
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {
    /**
     * importar servicio cliente
     */
    @Autowired
    private ClientService clientService;
    
    /**
     * contolador para listar todos los clientes inscritos en la base de datos cliente
     */
    @GetMapping("/all")
    public List<Client> getClients(){
        return clientService.getAll();
    }
    
    /**
     * contolador para obtener un cliente  relacionado por el id client
     */
    @GetMapping("/obtener/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }
    
    /**
     * contolador para guardar 1 nuevo cliente en la base de datos client
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c){
        return clientService.save(c);
    }
    
    /**
     * contolador para eliminar un elemento de  la base de datos client
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
    	 clientService.deleteId(id);
    }
    
    /**
     *contolador para actualizar un elementos ya creado en la base de datos client
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client c) {
    	 return clientService.update(c);
    }
}
