package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.crud.ReservationCrudRepository;

/**
 * repositorio CRUD proyecto Cuatrimotos Reservation
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Repository
public class ReservationRepository {
	
	/**
	 * importar repositorio Reservation
	 */
	@Autowired
	private ReservationCrudRepository reservationCrudRepository;

	/**
	 * obtener todos los elementos de  Reservation
	 */
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    /**
 	 * obtener por id el Reservation
 	 */
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
	/**
	 * guardar nuevo elemento en Reservation
	 */
    public Reservation save(Reservation c){
        return reservationCrudRepository.save(c);
    }
    
    /**
     * eliminar por id elemento en Reservation
     */
    public void deleteId(Integer id) {
    	reservationCrudRepository.deleteById(id);
    }
    
	/**
	 * actualizar datos de Reservation
	 */
    public Reservation update(Reservation c) {
    	return reservationCrudRepository.save(c);
	}
}
