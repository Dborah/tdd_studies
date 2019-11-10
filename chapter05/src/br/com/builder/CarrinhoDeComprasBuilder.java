package br.com.builder;

import br.com.controller.CarrinhoDeCompras;
import br.com.model.Item;

//utiliza o padrão de projeto Builder para criar facilmente uma classe de testes
public class CarrinhoDeComprasBuilder {
	
	public CarrinhoDeCompras carrinho;
	
	public CarrinhoDeComprasBuilder() {
		this.carrinho = new CarrinhoDeCompras();
	}
	
	public CarrinhoDeComprasBuilder comItens(double... valores) {
		for(double valor : valores) {
			carrinho.adiciona(new Item("item", 1, valor));
		}
		return this;
	}
	
	public CarrinhoDeCompras cria() {
		return carrinho;
	}

}//class CarrinhoDeComprasBuilder
