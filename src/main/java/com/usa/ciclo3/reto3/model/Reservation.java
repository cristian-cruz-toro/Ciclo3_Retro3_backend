/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.reto3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author camna
 */
@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	private Date startDate;
	private Date devolutionDate;
	private String status;

	@ManyToOne
	@JoinColumn(name = "quadbikeId")
	@JsonIgnoreProperties("reservations")
	private Quadbike quadbike;

	@ManyToOne
	@JoinColumn(name = "clientId")
	@JsonIgnoreProperties({"reservations","messages"})
	private Client client;

	private String score;
	/**
	 * @return the idReservation
	 */
	public Integer getIdReservation() {
		return idReservation;
	}

	/**
	 * @param idReservation the idReservation to set
	 */
	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the devolutionDate
	 */
	public Date getDevolutionDate() {
		return devolutionDate;
	}

	/**
	 * @param devolutionDate the devolutionDate to set
	 */
	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the quadbike
	 */
	public Quadbike getQuadbike() {
		return quadbike;
	}

	/**
	 * @param quadbike the quadbike to set
	 */
	public void setQuadbike(Quadbike quadbike) {
		this.quadbike = quadbike;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
}
