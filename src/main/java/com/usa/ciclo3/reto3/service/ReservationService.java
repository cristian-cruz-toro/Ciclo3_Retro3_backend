package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.model.Quadbike;
import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.ReservationRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save (Reservation r){
        if(r.getIdReservation()==null){
            r.setStatus("created");
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if(!raux.isPresent()){
                r.setStatus("created");
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault());
//                r.setStartDate(sdf.format(new Date()));
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
}
