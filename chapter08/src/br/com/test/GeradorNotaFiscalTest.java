package br.com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.controller.GeradorDeNotaFiscal;
import br.com.model.AcaoAposGerarNota;
import br.com.model.NotaFiscal;
import br.com.model.Pedido;
import br.com.model.Tabela;

public class GeradorNotaFiscalTest {
	
	@Test
	public void  deveInvocarAcoesPosteriores() {
		AcaoAposGerarNota acao1 = Mockito.mock(AcaoAposGerarNota.class);
		AcaoAposGerarNota acao2 = Mockito.mock(AcaoAposGerarNota.class);
		
		Tabela tabela = Mockito.mock(Tabela.class);
		
		List<AcaoAposGerarNota> acoes = Arrays.asList(acao1, acao2);
		
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes, tabela);
		Pedido pedido = new Pedido("deborah", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		Mockito.verify(acao1).executa(nf);
		Mockito.verify(acao2).executa(nf);
	}
	
	
	@Test
	public void deveConsultarATabelaParaCalcularValor() {
		Tabela tabela = Mockito.mock(Tabela.class);
		
		//definindo o futuro comportamento "paravalor"
		//que deve retornar 0.2 caso o valor seja 1000.0
		Mockito.when(tabela.paravalor(1000.0)).thenReturn(0.2);
		
		List<AcaoAposGerarNota> nenhumaAcao = Collections.emptyList();
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(nenhumaAcao, tabela);
		Pedido pedido = new Pedido("deborah", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		//garantindo que a tabela foi consultada.
		Mockito.verify(tabela).paravalor(1000.0);
		assertEquals(1000 * 0.2, nf.getValor(), 0.00001);
	}
}//class GeradorNotaFiscalTest {
