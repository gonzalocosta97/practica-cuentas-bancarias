package ar.edu.unlam.cuentas;

public class CajaAhorro extends Cuenta {
	
	// Atributos
	
	private Integer nExtraccion= 1;
	
	// Constructor/es
	
	public CajaAhorro() {
		
		super();
		
	}
	
	// Métodos 
	
	@Override
	public void extraer(Double importe) {
		
		if (importe > 0) {
			
			Double costoAdicional = 6.0;	

			if (nExtraccion <= 5 && importe <= this.saldo) {
				
				this.saldo -= importe;
				
				this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.EXTRACCION, importe));
				
				nExtraccion++;
			
			} 
			
			else if (nExtraccion > 5 && importe + costoAdicional <= this.saldo) {
				
				this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.EXTRACCION, importe));
				
				this.transaccionesCuenta.add(new Transaccion(TipoTransaccion.COSTO_EXTRACCION, costoAdicional));
				
				importe += costoAdicional;
				
				this.saldo -= importe;
				
				nExtraccion++;
			
			}
		
		}
		
	}

}
