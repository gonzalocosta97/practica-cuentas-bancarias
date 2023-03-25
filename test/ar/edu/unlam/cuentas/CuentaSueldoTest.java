package ar.edu.unlam.cuentas;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class CuentaSueldoTest {
	
	// Tests

	@Test
	public void queAlCrearUnaCuentaSueldoSuSaldoSeaCero() {
		
		CuentaSueldo cuenta = cuandoCreoUnaCuentaSueldo();
		
		entoncesSuSaldoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queSePuedaDepositarUnImporteEnUnaCuentaSueldo() {
		
		CuentaSueldo cuenta = dadoQueExisteUnaCuentaSueldo();
		
		cuandoDepositoSaldo(cuenta, 10000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
		
	}
	
	@Test
	public void queNoSePuedaDepositarUnImporteNegativoEnUnaCuentaSueldo() { 
		
		CuentaSueldo cuenta = dadoQueExisteUnaCuentaSueldo();
		
		cuandoDepositoSaldo(cuenta, -10000.0);
		
		entoncesSuSaldoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queSePuedaExtraerUnImporteDeUnaCuentaSueldo() {
		
		CuentaSueldo cuenta = dadoQueExisteUnaCuentaSueldo();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		entoncesSuSaldoEs(cuenta, 9000.0);
		
	}
	
	@Test
	public void queNoSePuedaExtraerUnImporteNegativoDeUnaCuentaSueldo() {
		
		CuentaSueldo cuenta = dadoQueExisteUnaCuentaSueldo();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, -1000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
		
	}
	
	@Test
	public void queNoSePuedaExtraerUnImporteSuperiorAlSaldoDisponibleEnUnaCuentaSueldo() {
		
		CuentaSueldo cuenta = dadoQueExisteUnaCuentaSueldo();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 11000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
		
	}
	
	@Test
	public void queSeRegistreLaTransaccionCuandoSeDepositaEnUnaCuentaSueldo() {
		
		CuentaSueldo cuenta = dadoQueExisteUnaCuentaSueldo();
		
		cuandoDepositoSaldo(cuenta, 10000.0);
		
		entoncesExisteTransaccion(cuenta, 1);
		
	}
	
	@Test
	public void queSeRegistreLaTransaccionCuandoSeRealizaUnaExtraccionEnUnaCuentaSueldo() {
		
		CuentaSueldo cuenta = dadoQueExisteUnaCuentaSueldo();
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		entoncesExisteTransaccion(cuenta, 2);
		
	}
	
	// Métodos
	
	private CuentaSueldo cuandoCreoUnaCuentaSueldo() {
		
		return new CuentaSueldo();
		
	}
	
	private CuentaSueldo dadoQueExisteUnaCuentaSueldo() {
		
		return new CuentaSueldo();
		
	}
	
	private void entoncesSuSaldoEs(CuentaSueldo cuenta, Double saldo) {
		
		Double valorEsperado = saldo;
		
		Double valorObtenido = cuenta.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	private void cuandoDepositoSaldo(CuentaSueldo cuenta, Double saldo) {
		
		cuenta.depositar(saldo);
		
	}
	
	private void dadoQueDepositoSaldo(CuentaSueldo cuenta, Double saldo) {
		
		cuenta.depositar(saldo);
		
	}
	
	private void cuandoExtraigoSaldo(CuentaSueldo cuenta, Double saldo) {
		
		cuenta.extraer(saldo);
		
	}
	
	private void entoncesExisteTransaccion(CuentaSueldo cuenta, Integer numeroTransacciones) {
		
		Integer valorEsperado = numeroTransacciones;
		
		ArrayList<Transaccion> transaccionesCuenta = cuenta.getTransaccionesCuenta();
		
		Integer valorObtenido = transaccionesCuenta.size();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
}
