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

import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.service.MessageService;

/**
 * controllador CRUD proyecto Cuatrimotos message
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class MessageController {
	  /**
     * importar servicio message
     */
	@Autowired
	private MessageService messageService;

	  /**
     * contolador para listar todos los clientes inscritos en la base de datos Message
     */
	@GetMapping("/all")
	public List<Message> getMessages() {
		return messageService.getAll();
	}

	   /**
     * contolador para obtener un cliente  relacionado por el id Message
     */
	@GetMapping("/obtener/{id}")
	public Optional<Message> getMessage(@PathVariable("id") int id) {
		return messageService.getMessage(id);
	}

	 /**
     * contolador para guardar 1 nuevo cliente en la base de datos Message
     */
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message save(@RequestBody Message m) {
		return messageService.save(m);
	}

    /**
     * contolador para eliminar un elemento de  la base de datos Message
     */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		messageService.deleteId(id);
	}

	  /**
     *contolador para actualizar un elementos ya creado en la base de datos message
     */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Message update(@RequestBody Message c) {
		return messageService.update(c);
	}
}
