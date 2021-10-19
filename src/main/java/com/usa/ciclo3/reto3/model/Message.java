/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.reto3.model;

import java.io.Serializable;

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
@Table(name = "Message")
public class Message implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMessage;
	private String messageText;

	@ManyToOne
	@JoinColumn(name = "quadbikeId")
	@JsonIgnoreProperties({"messages", "client", "reservations"})
	private Quadbike quadbike;

	@ManyToOne
	@JoinColumn(name = "clientId")
	@JsonIgnoreProperties({"messages", "reservations", "client"})
	private Client client;

	/**
	 * @return the idMessage
	 */
	public Integer getIdMessage() {
		return idMessage;
	}

	/**
	 * @param idMessage the idMessage to set
	 */
	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}

	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
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

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
}
