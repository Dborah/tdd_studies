package br.com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.controller.ProcessadorDeBoletos;
import br.com.model.Boleto;
import br.com.model.Fatura;

public class ProcessadorDeBoletosTest {
	
	@Test
	public void deveProcessarPagamentoViaBoletoUnico() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("cliente", 150.0);
		Boleto b1 = new Boleto(150.0);
		List<Boleto> boletos = Arrays.asList(b1);
		
		processador.processa(boletos, fatura);
		
		assertEquals(1, fatura.getPagamentos().size());
		assertEquals(150.0, fatura.getPagamentos().get(0).getValor(), 0.00001);
	}

	@Test 
	public void deveProcessarPagamentoViaMuitosBoletos() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("Cliente", 300.0);
		Boleto b1 = new Boleto(100.0);
		Boleto b2 = new Boleto(200.0);
		List<Boleto> boletos = Arrays.asList(b1, b2);
		
		processador.processa(boletos, fatura);
		
		assertEquals(2, fatura.getPagamentos().size());
		assertEquals(100.0,fatura.getPagamentos().get(0).getValor(), 0.00001);
		assertEquals(200.0,fatura.getPagamentos().get(1).getValor(), 0.00001);
		
		
	}
	
	@Test
	public void deveMarcarFaturaComoPagaCasoBoletoUnicoPagueTudo() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("Wagner", 150.00);
		Boleto b1 = new Boleto(150.00);
		List<Boleto> boletos = Arrays.asList(b1);
		
		processador.processa(boletos, fatura);
		
		assertTrue(fatura.isPago());
	}
	
	@Test
	public void deveMarcarFaturaComoNaoPagaCasoBoletoUnicoNaoPagueTudo() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("Wagner", 150.00);
		Boleto b1 = new Boleto(100.00);
		List<Boleto> boletos = Arrays.asList(b1);
		
		processador.processa(boletos, fatura);
		
		assertFalse(fatura.isPago());
	}
	
	
	

}//class ProcessadorDeBoletosTest
