package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.ClientRepository;

/**
 * servicio CRUD proyecto Cuatrimotos client
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */

@Service
public class ClientService {

	/**
	 * importar repositorio cliente
	 */
	@Autowired
	private ClientRepository clientRepository;

	/**
	 * obtener todos los elementos de client
	 */
	public List<Client> getAll() {
		return clientRepository.getAll();
	}

	/**
	 * obtener por id el client
	 */
	public Optional<Client> getClient(int id) {
		return clientRepository.getClient(id);
	}

	/**
	 * guardar nuevo elemento en client
	 */
	public Client save(Client c) {
		if (c.getIdClient() == null) {
			return clientRepository.save(c);
		} else {
			Optional<Client> caux = clientRepository.getClient(c.getIdClient());
			if (!caux.isPresent()) {
				return clientRepository.save(c);
			} else {
				return c;
			}
		}
	}

	/**
	 * eliminar por id elemento en category
	 */
	public void deleteId(Integer id) {
		try {
			clientRepository.deleteId(id);
		} catch (Exception e) {
		}
	}

	/**
	 * actualizar datos de category
	 */
	public Client update(Client c) {
		if (c.getIdClient() != null) {
			Optional<Client> cli = clientRepository.getClient(c.getIdClient());
			if (!cli.isEmpty()) {
				if (c.getName() != null) {
					cli.get().setName(c.getName());
				}
				if (c.getAge() != null) {
					cli.get().setAge(c.getAge());
				}
				if (c.getEmail() != null) {
					cli.get().setEmail(c.getEmail());
				}
				if (c.getPassword() != null) {
					cli.get().setPassword(c.getPassword());
				}
				if (c.getMessages() != null) {
					cli.get().setMessages(c.getMessages());
				}
				if (c.getReservations() != null) {
					cli.get().setReservations(c.getReservations());
				}
				clientRepository.save(cli.get());
				return cli.get();
			} else {
				return c;
			}
		} else {
			return c;
		}
	}
}
