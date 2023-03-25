package ar.edu.unlam.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class CuentaCorrienteTest {

	// Tests

	@Test
	public void queAlCrearUnaCuentaCorrienteSeEstablezcaUnMontoEnDescubierto() {

		CuentaCorriente cuenta = cuandoCreoUnaCuentaCorriente(1000.0);
		
		entoncesSuSaldoEnDescubiertoEs(cuenta, 1000.0);

	}
	
	@Test
	public void queAlCrearUnaCuentaCorrienteSuSaldoSeaCero() {
		
		CuentaCorriente cuenta = cuandoCreoUnaCuentaCorriente(1000.0);
		
		entoncesSuSaldoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queSePuedaDepositarUnImporteEnUnaCuentaCorriente() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		cuandoDepositoSaldo(cuenta, 10000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
		
	}
	
	@Test
	public void queNoSePuedaDepositarUnImporteNegativoEnUnaCuentaCorriente() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		cuandoDepositoSaldo(cuenta, -10000.0);
		
		entoncesSuSaldoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queSePuedaExtraerUnImporteDeUnaCuentaCorriente() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		entoncesSuSaldoEs(cuenta, 9000.0);
	
	}
	
	@Test
	public void queNoSePuedaExtraerUnImporteNegativoDeUnaCuentaCorriente() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, -2000.0);
		
		entoncesSuSaldoEs(cuenta, 10000.0);
		
	}
	
	@Test
	public void queSePuedaExtraerUnImporteMayorAlSaldoDisponibleSiLoPuedeCubrirElDescubierto() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 10800.0);
		
		entoncesSuSaldoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queSePuedaObtenerElDescubiertoUsado( ) {
	
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 10800.0);
		
		entoncesSuDescubiertoUsadoEs(cuenta, 800.0);
		
	}
	
	@Test
	public void queSeCargueLaDeudaConElBancoSiSeUsaElDescubierto() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 10800.0);
		
		entoncesSuDeudaConElBancoEs(cuenta, 840.0);
		
	}
	
	@Test
	public void queNoSePuedaExtraerUnImporteMayorAlSaldoDisponibleSiExcedeElDescubiertoDisponible() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 10800.0);
		
		cuandoExtraigoSaldo(cuenta, 300.0);
		
		entoncesSuDescubiertoUsadoEs(cuenta, 800.0);
		
	}
	
	@Test
	public void queAlRelizarUnDepositoPrimeroSeTengaQueSaldarLaDeudaConElBancoEnCasoDeExistir() {
	
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		dadoQueExtraigoSaldo(cuenta, 10800.0);
		
		cuandoDepositoSaldo(cuenta, 2000.0);
		
		entoncesSuSaldoEs(cuenta, 1160.0);
		
	}
	
	@Test
	public void queUnDepositoSaldeParcialmenteLaDeudaConElBancoSiNoLaLlegaACubrirDeManeraCompleta() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		dadoQueExtraigoSaldo(cuenta, 11000.0);
		
		cuandoDepositoSaldo(cuenta, 800.0);
		
		entoncesSuDeudaConElBancoEs(cuenta, 250.0);
		
	}
	
	@Test
	public void queSePongaEnCeroElDescubiertoUsadoCuandoSeSaldaElTotalDeLaDeudaConElBanco() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		dadoQueExtraigoSaldo(cuenta, 11000.0);
		
		cuandoDepositoSaldo(cuenta, 2000.0);
				
		entoncesSuDescubiertoUsadoEs(cuenta, 0.0);
		
	}
	
	@Test
	public void queElDescubiertoUsadoNoDisminuyaSiNoSeSaldaElTotalDeLaDeudaConElBanco() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		dadoQueExtraigoSaldo(cuenta, 10500.0);
		
		cuandoDepositoSaldo(cuenta, 300.0);
		
		entoncesSuDescubiertoUsadoEs(cuenta, 500.0);
		
	}
	
	@Test
	public void queSeRegistreLaTransaccionCuandoSeDepositaEnUnaCuentaCorriente() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		cuandoDepositoSaldo(cuenta, 10000.0);
		
		entoncesExisteTransaccion(cuenta, 1);
		
	}
	
	@Test
	public void queSeRegistreLaTransaccionCuandoSeRelizaUnaExtraccionEnUnaCuentaCorriente() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
				
		entoncesExisteTransaccion(cuenta, 2);
		
	}
	
	@Test 
	public void queSeRegistreLaTransaccionCuandoLaExtraccionUtilizaElDescubierto() {
		
		CuentaCorriente cuenta = dadoQueExisteUnaCuentaCorriente(1000.0);
		
		dadoQueDepositoSaldo(cuenta, 10000.0);
		
		cuandoExtraigoSaldo(cuenta, 1000.0);
		
		cuandoExtraigoSaldo(cuenta, 9500.0);
		
		entoncesExisteTransaccion(cuenta, 4);
				
	}
	
	// Métodos 
	
	private CuentaCorriente cuandoCreoUnaCuentaCorriente(Double descubierto) {
		
		return new CuentaCorriente(descubierto);
		
	}
	
	private CuentaCorriente dadoQueExisteUnaCuentaCorriente(Double descubierto) {
		
		return new CuentaCorriente(descubierto);
		
	}
	
	private void entoncesSuSaldoEnDescubiertoEs(CuentaCorriente cuenta, Double saldo) {
		
		Double valorEsperado = saldo;
		
		Double valorObtenido = cuenta.getDescubierto();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	private void entoncesSuSaldoEs(CuentaCorriente cuenta, Double saldo) {
		
		Double valorEsperado = saldo;
		
		Double valorObtenido = cuenta.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	private void cuandoDepositoSaldo(CuentaCorriente cuenta, Double saldo) {
		
		cuenta.depositar(saldo);
		
	}
	
	private void dadoQueDepositoSaldo(CuentaCorriente cuenta, Double saldo) {
		
		cuenta.depositar(saldo);
		
	}

	private void cuandoExtraigoSaldo(CuentaCorriente cuenta, Double saldo) {
		
		cuenta.extraer(saldo);
		
	}
	
	private void dadoQueExtraigoSaldo(CuentaCorriente cuenta, Double saldo) {
		
		cuenta.extraer(saldo);
		
	}
	
	private void entoncesSuDescubiertoUsadoEs(CuentaCorriente cuenta, Double saldo) {
		
		Double valorEsperado = saldo;
		
		Double valorObtenido = cuenta.getDescubiertoUsado();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	private void entoncesSuDeudaConElBancoEs(CuentaCorriente cuenta, Double saldo) {
		
		Double valorEsperado = saldo;
		
		Double valorObtenido = cuenta.getDeudaConElBanco();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	private void entoncesExisteTransaccion(CuentaCorriente cuenta, Integer numeroTransacciones) {
		
		Integer valorEsperado = numeroTransacciones;
		
		ArrayList<Transaccion> transaccionesCuenta = cuenta.getTransaccionesCuenta();
		
		Integer valorObtenido = transaccionesCuenta.size();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
}
