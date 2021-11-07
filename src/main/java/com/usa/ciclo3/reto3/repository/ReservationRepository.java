package com.usa.ciclo3.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.BestClient;
import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
	@Autowired
	private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation c){
        return reservationCrudRepository.save(c);
    }
    public void deleteId(Integer id) {
    	reservationCrudRepository.deleteById(id);
    }
    
    public Reservation update(Reservation c) {
    	return reservationCrudRepository.save(c);
	}
    
    public List<Reservation> reservasPorFecha(Date FechaI,Date FechaF) {
    	return reservationCrudRepository.porfecha(FechaI,FechaF);
	}
    
    public Integer cantidadReservaCompetada() {
    	int r= reservationCrudRepository.cantidadReservaCompletada();
    	return r;
	}
    
    public Integer cantidadReservaCancelada() {
    	int r= reservationCrudRepository.cantidadReservaCancelada();
    	return r;
	}
    
    public List<BestClient> mejoresClientes() {
    	List<BestClient> respuesta= new ArrayList<>();
    	List<Object[]> report= reservationCrudRepository.mejoresClientes();
   	 for(int i=0;i<report.size();i++) {
   		Client cli=(Client)report.get(i)[0];
   		Long cantidad=(Long)report.get(i)[1];
   		BestClient mejorCliente=new BestClient(cantidad,cli);
   		respuesta.add(mejorCliente);
   		
	 }
    	
    	return respuesta;
	}
}
