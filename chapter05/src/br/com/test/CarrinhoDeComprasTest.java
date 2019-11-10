package br.com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.controller.CarrinhoDeCompras;
import br.com.model.Item;

public class CarrinhoDeComprasTest {
	
	private CarrinhoDeCompras carrinho;
	
	//instância o objeto antes que cada teste seja executado
	@Before
	public void inicializa() {
		this.carrinho =  new CarrinhoDeCompras();
	}
	
	
	@Test
	public void deveRetornarZeroSeCarrinhoVazio() {
		assertEquals(0.0, carrinho.maiorValor(), 0.0001);
	}
	
	@Test
	public void deveRetornarValorDoItemSeCarrinhoCom1Elemento() {
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		
		assertEquals(900.0, carrinho.maiorValor(), 0.0001);
	}
	
	@Test
	public void deveRetornarMaiorValorSeCarrinhoContemMuitosElementos() {
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		carrinho.adiciona(new Item("Fogão", 1, 1500.0));
		carrinho.adiciona(new Item("Máquina de labar", 1, 750.0));
		
		assertEquals(1500.0, carrinho.maiorValor(), 0.0001);
	}
}// class MaiorPrecoTest
