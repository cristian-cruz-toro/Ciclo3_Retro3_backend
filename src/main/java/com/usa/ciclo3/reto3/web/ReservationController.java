package com.usa.ciclo3.reto3.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.usa.ciclo3.reto3.model.BestClient;
import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.model.count;
import com.usa.ciclo3.reto3.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
   
    @Autowired
    private count numeroReserva;
    
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    
    @GetMapping("/obtener/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation q){
        return reservationService.save(q);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
    	reservationService.deleteId(id);
    }
    
    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation c) {
    	return reservationService.update(c);
    }
    
    @GetMapping("/report-dates/{fechaInicial}/{fechaFinal}")
    public List<Reservation> reservasPorFecha(@PathVariable("fechaInicial") String fechaInicial,@PathVariable("fechaFinal") String fechaFinal) throws ParseException{
    	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    	return reservationService.reservasPorFecha(formato.parse(fechaInicial),formato.parse(fechaFinal));
    }
    
    @GetMapping("/report-status")
    public count reservasPorFecha(){
        return reservationService.cantidadReserva();
    }
    
    @GetMapping("/report-clients")
    public List<BestClient> reservasClientes(){
         return reservationService.mejoresClientes();
    }
}
