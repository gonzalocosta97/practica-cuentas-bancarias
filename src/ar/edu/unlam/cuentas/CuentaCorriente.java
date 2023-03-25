package ar.edu.unlam.cuentas;

public class CuentaCorriente extends Cuenta {
	
	// Atributos
	
	private Double descubierto;
	
	private Double descubiertoUsado = 0.0;
	
	private Double deudaConElBanco = 0.0;
	
	private static Double interesUsoDescubierto = 0.05;
	
	// Contructor/es
	
	public CuentaCorriente(Double descubierto) {
		
		super();
		
		this.descubierto = descubierto;
		
	}
	
	// Métodos
	
	public Double getDescubierto() {
		
		return this.descubierto;
		
	}
	
	public Double getDescubiertoUsado() {
		
		return this.descubiertoUsado;
		
	}
	
	public Double getDeudaConElBanco() {
		
		return deudaConElBanco;
		
	}
	
	@Override
	public void extraer(Double importe) {
		
		if (importe > 0) {
		
			if (importe <= this.saldo) {
				
				this.saldo -= importe;
				
				this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.EXTRACCION, importe));
				
			} 
			
			else if (importe <= this.saldo + this.descubierto - this.descubiertoUsado){
				
				Double cubiertoPorDescubierto = importe - this.getSaldo();
				
				Double comisionDescubierto = cubiertoPorDescubierto * interesUsoDescubierto;

				this.descubiertoUsado += cubiertoPorDescubierto;
				
				this.deudaConElBanco+= cubiertoPorDescubierto + comisionDescubierto;
				
				this.saldo -= saldo;
				
				this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.EXTRACCION, importe));
				
				this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.COMISION_EXTRACCION, comisionDescubierto));
				
			}
		
		}
	}
	
	@Override
	public void depositar(Double importe) {
		
		if (importe > 0) {
			
			if (this.deudaConElBanco==0) {
				
				this.saldo += importe;
				
			} else if (this.deudaConElBanco > 0 && importe >= this.deudaConElBanco) {
				
				this.saldo += importe - this.deudaConElBanco;
				
				this.deudaConElBanco -= this.deudaConElBanco;
				
				this.descubiertoUsado = 0.0;
				
			} else if (this.deudaConElBanco > 0 && importe < this.deudaConElBanco) {
				
				this.deudaConElBanco -= importe;
				
			} 
			
			this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.DEPOSITO, importe));
			
		}
		
	}
	
}
