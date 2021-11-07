package com.usa.ciclo3.reto3.model;

import org.springframework.stereotype.Component;

@Component
public class count {
	
	private Integer completed;
	private Integer cancelled;
	
	public Integer getCompleted() {
		return completed;
	}
	public void setCompleted(Integer completed) {
		this.completed = completed;
	}
	public Integer getCancelled() {
		return cancelled;
	}
	public void setCancelled(Integer cancelled) {
		this.cancelled = cancelled;
	}

} 
