package ar.edu.unlam.cuentas;

import java.util.*;

public abstract class Cuenta {
	
	// Atributos

	protected Double saldo;
	
	protected ArrayList<Transaccion> transaccionesCuenta = new ArrayList<Transaccion>();
	
	// Constructor/es
	
	public Cuenta() {
		
		this.saldo = 0.0;
		
	}
	
	// Métodos
	
	public Double getSaldo() {
		
		return this.saldo;
		
	}
	
	public ArrayList<Transaccion> getTransaccionesCuenta() {
		
		return this.transaccionesCuenta;
		
	}
	
	public void depositar(Double importe) {
		
		if (importe > 0) {
		
			this.saldo += importe;
			
			this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.DEPOSITO, importe));
			
		}
		
		
	}
	
	public void extraer(Double importe) {
		
		if (importe > 0 && importe <= this.saldo) {
		
			this.saldo -= importe;
			
			this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.EXTRACCION, importe));
		
		}
		
	}
	
}
