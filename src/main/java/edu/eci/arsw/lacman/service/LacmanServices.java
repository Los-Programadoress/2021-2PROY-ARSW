package edu.eci.arsw.lacman.service;

import org.springframework.stereotype.Service;

@Service
public class LacmanServices{
	
	private String saludo="saludo";

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
}