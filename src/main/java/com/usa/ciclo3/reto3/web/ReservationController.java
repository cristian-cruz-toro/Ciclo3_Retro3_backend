package com.usa.ciclo3.reto3.web;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.service.ReservationService;
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

/**
 * controllador CRUD proyecto Cuatrimotos reservacion
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version1
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
	  /**
     * importar servicio Reservation
     */
    @Autowired
    private ReservationService reservationService;
    
	  /**
     * contolador para listar todos los clientes inscritos en la base de datos Reservation
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    
    /**
	* contolador para obtener un cliente  relacionado por el id Reservation
	*/
    @GetMapping("/obtener/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    
    /**
     * contolador para guardar 1 nuevo cliente en la base de datos Reservation
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation q){
        return reservationService.save(q);
    }
    
    /**
     * contolador para eliminar un elemento de  la base de datos Reservation
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id){
    	reservationService.deleteId(id);
    }
    
	 /**
     *contolador para actualizar un elementos ya creado en la base de datos Reservation
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation c) {
    	return reservationService.update(c);
    }
}
