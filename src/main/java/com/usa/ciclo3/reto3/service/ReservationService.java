package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.ReservationRepository;

/**
 * servicio CRUD proyecto Cuatrimotos Reservation
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@Service
public class ReservationService {

	/**
	 * importar repositorio Reservation
	 */
	@Autowired
	private ReservationRepository reservationRepository;

	/**
	 * obtener todos los elementos de Reservation
	 */
	public List<Reservation> getAll() {
		return reservationRepository.getAll();
	}

	/**
	 * obtener por id el Reservation
	 */
	public Optional<Reservation> getReservation(int id) {
		return reservationRepository.getReservation(id);
	}

	/**
	 * guardar nuevo elemento en Reservation
	 */
	public Reservation save(Reservation r) {
		if (r.getIdReservation() == null) {
			r.setStatus("created");
			return reservationRepository.save(r);
		} else {
			Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
			if (!raux.isPresent()) {
				r.setStatus("created");
				return reservationRepository.save(r);
			} else {
				return r;
			}
		}
	}

	/**
	 * eliminar por id elemento en Reservation
	 */
	public void deleteId(Integer id) {
		try {
			reservationRepository.deleteId(id);
		} catch (Exception e) {
		}
	}

	/**
	 * actualizar datos de Reservation
	 */
	public Reservation update(Reservation c) {
		if (c.getIdReservation() != null) {
			Optional<Reservation> res = reservationRepository.getReservation(c.getIdReservation());
			if (!res.isEmpty()) {
				if (c.getStartDate() != null) {
					res.get().setStartDate(c.getStartDate());
				}
				if (c.getDevolutionDate() != null) {
					res.get().setDevolutionDate(c.getDevolutionDate());
				}
				if (c.getStatus() != null) {
					res.get().setStatus(c.getStatus());
				}
				if (c.getQuadbike() != null) {
					res.get().setQuadbike(c.getQuadbike());
				}
				if (c.getClient() != null) {
					res.get().setClient(c.getClient());
				}

				reservationRepository.save(res.get());
				return res.get();
			} else {
				return c;
			}
		} else {
			return c;
		}
	}
}
