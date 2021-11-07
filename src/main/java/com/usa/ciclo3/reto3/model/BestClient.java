package com.usa.ciclo3.reto3.model;

import org.springframework.stereotype.Component;


public class BestClient {
	
	private Long total;

	private Client client;
	
	public BestClient(Long total, Client client) {
		super();
		this.total = total;
		this.client = client;
	}
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
