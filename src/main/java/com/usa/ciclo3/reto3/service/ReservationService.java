package com.usa.ciclo3.reto3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.BestClient;
import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.model.count;
import com.usa.ciclo3.reto3.repository.ReservationRepository;


@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private count numeroReserva;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save (Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if(!raux.isPresent()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
    
    public  void deleteId(Integer id) {
    	try {			
    		reservationRepository.deleteId(id);
    	} catch (Exception e) {
    	}
    }
    
    public  Reservation update(Reservation c) {
             return reservationRepository.save(c);
    }
    
    public List<Reservation> reservasPorFecha(Date FechaI,Date FechaF) {
    	if(FechaI.before(FechaF)) {
    		System.out.println(FechaI);
    		System.out.println(FechaF);
    		return reservationRepository.reservasPorFecha(FechaI,FechaF);
    	}else {
    		return new ArrayList<>();
    	}
    }
    public count cantidadReserva() {
    	int valor2=reservationRepository.cantidadReservaCancelada();
    	int valor=reservationRepository.cantidadReservaCompetada();
        numeroReserva.setCancelled(valor2);
        numeroReserva.setCompleted(valor);
        return numeroReserva;
    }
    
     public List<BestClient> mejoresClientes() {
    	 return   reservationRepository.mejoresClientes();
     }
    
}
