/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.crud.MessageCrudRepository;


@Repository
public class MessageRepository {
	@Autowired
	private MessageCrudRepository messageCrudRepository;

	public List<Message> getAll() {
		return (List<Message>) messageCrudRepository.findAll();
	}

	public Optional<Message> getMessage(int id) {
		return messageCrudRepository.findById(id);
	}

	public Message save(Message m) {
		return messageCrudRepository.save(m);
	}
}
