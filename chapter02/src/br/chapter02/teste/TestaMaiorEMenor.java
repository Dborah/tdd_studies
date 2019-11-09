package br.chapter02.teste;

import br.chapter02.controller.CarrinhoDeCompras;
import br.chapter02.controller.MaiorEMenor;
import br.chapter02.model.Produto;

import org.junit.Assert;
import org.junit.Test;


public class TestaMaiorEMenor {
	@Test
	public void ordemDecrescente() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		Produto produtos[] = {new Produto("Geladeira", "Muito boa", 450.0),
				  			  new Produto("Liquidificador", "Muito bom", 250.0),
				  			  new Produto("Jogo de pratos", "Duvidoso", 70.0)};
		
		carrinho.add(produtos);
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		Assert.assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
		
	}
	
	@Test
	public void apenasUmProduto(){
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.add(new Produto("Geladeira", "Muito boa", 450.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		Assert.assertEquals("Geladeira", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
	
	@Test
	public void ordemCrescente(){
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		Produto produtos[] = { new Produto("Jogo de pratos", "Duvidoso", 70.0),
							   new Produto("Liquidificador", "Muito bom", 250.0),
							   new Produto("Geladeira", "Muito boa", 450.0)};
		carrinho.add(produtos);
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
			
		Assert.assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
	
}//class TestaMaiorEMenor 
