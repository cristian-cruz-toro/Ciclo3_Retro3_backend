package com.usa.ciclo3.reto3.repository.crud;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.model.Reservation;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository  extends CrudRepository<Reservation, Integer>{
	
	@Query("SELECT res FROM Reservation AS res WHERE res.startDate>:FechaI and res.startDate<:FechaF")
	List<Reservation> porfecha(Date FechaI,Date FechaF);
	
	@Query("SELECT COUNT(res.status) FROM Reservation AS res WHERE res.status ='completed'")
	Integer cantidadReservaCompletada();
    
	@Query("SELECT COUNT(res.status) FROM Reservation AS res WHERE res.status ='cancelled'")
	Integer cantidadReservaCancelada();
	
	@Query("SELECT res.client, COUNT(res.client) FROM Reservation AS res GROUP BY res.client ORDER BY COUNT(res.client) desc")
	List<Object[]> mejoresClientes();
}
