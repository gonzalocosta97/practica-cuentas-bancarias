package ar.edu.unlam.cuentas;

import java.util.*;

public class Transaccion {
	
	// Atributos
	
	private TipoTransaccion tipo;
	
	private Double monto;
	
	private Date fecha;
	
	// Constructor/es
	
	public Transaccion(TipoTransaccion tipo, Double monto) {
		
		this.tipo = tipo;
		
		this.monto = monto;
		
		this.fecha = new Date();
		
	}
	
	// Métodos
	
	@Override
	public String toString() {
		
		return this.tipo + " | " + this.monto + " | " + this.fecha;
		
	}

}
