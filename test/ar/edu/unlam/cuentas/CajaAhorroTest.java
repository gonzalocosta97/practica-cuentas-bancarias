package ar.edu.unlam.cuentas;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class CajaAhorroTest {
	
	// Tests

	@Test
	public void queAlCrearUnaCajaDeAhorroSuSaldoSeaCero() {
		
		CajaAhorro cuenta = cuandoCreoUnaCajaDeAhorro();
		
		entoncesSuSaldoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queSePuedaDepositarUnImporteEnUnaCajaDeAhorro() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		cuandoDepositoSaldo(cuenta, 10000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
		
	}
	
	@Test
	public void queNoSePuedaDepositarUnImporteNegativoEnUnaCajaDeAhorro() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		cuandoDepositoSaldo(cuenta, -10000.0);
		
		entoncesSuSaldoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queSePuedaExtraerUnImporteDeUnaCajaDeAhorro() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		entoncesSuSaldoEs(cuenta, 9000.0);
		
	}
	
	@Test
	public void queNoSePuedaExtraerUnImporteNegativoDeUnaCajaDeAhorro() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, -1000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
		
	}
	
	@Test
	public void queNoSePuedaExtraerUnImporteSuperiorAlSaldoDisponibleEnUnaCajaDeAhorro() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 11000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
			
	}
	
	@Test
	public void queDespuesDeLaQuintaExtraccionSeCobreSeisPesosPorExtraccion() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);

		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		entoncesSuSaldoEs(cuenta, 2988.0);
		
	}
	
	@Test
	public void queDespuesDeLaQuintaExtraccionNoPuedaExtraerSiElMontoAExtraerConElCostoAdicionalEsMayorAlSaldo() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 3000.0);
		
		entoncesSuSaldoEs(cuenta, 2988.0);
		
	}
	
	@Test
	public void queSeRegistreLaTransaccionCuandoSeDepositaEnUnaCajaDeAhorro() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		cuandoDepositoSaldo(cuenta, 10000.0);
		
		entoncesExisteTransaccion(cuenta, 1);
		
	}
	
	@Test
	public void queSeRegistreLaTransaccionCuandoSeRelizaUnaExtraccionEnUnaCajaDeAhorro() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		entoncesExisteTransaccion(cuenta, 2);
				
	}
	
	@Test
	public void queSeRegistreLaTransaccionCuandoSeRealizaUnaExtraccionConCostoAdicional() {
		
		CajaAhorro cuenta = dadoQueExisteUnaCajaDeAhorro();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		entoncesExisteTransaccion(cuenta, 10);
		
	}
	
	// Métodos
	
	private CajaAhorro cuandoCreoUnaCajaDeAhorro() {
		
		return new CajaAhorro();
		
	}
	
	private CajaAhorro dadoQueExisteUnaCajaDeAhorro() {
			
		return new CajaAhorro();
		
	}
	
	private void entoncesSuSaldoEs(CajaAhorro cuenta, Double saldo) {
		
		Double valorEsperado = saldo;
		
		Double valorObtenido = cuenta.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	private void cuandoDepositoSaldo(CajaAhorro cuenta, Double saldo) {
		
		cuenta.depositar(saldo);
		
	}
	
	private void dadoQueDepositoSaldo(CajaAhorro cuenta, Double saldo) {
		
		cuenta.depositar(saldo);
		
	}
	
	private void cuandoExtraigoSaldo(CajaAhorro cuenta, Double saldo) {
		
		cuenta.extraer(saldo);
		
	}
	
	private void entoncesExisteTransaccion(CajaAhorro cuenta, Integer numeroTransacciones) {
		
		Integer valorEsperado = numeroTransacciones;
		
		ArrayList<Transaccion> transaccionesCuenta = cuenta.getTransaccionesCuenta();
		
		Integer valorObtenido = transaccionesCuenta.size();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}

}
