package br.com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.model.Item;

public class CarrinhoDeCompras {
	
	private List<Item> itens;
	
	public CarrinhoDeCompras() {
		this.itens = new ArrayList<Item>();
	}
	
	public void adiciona(Item item) {
		this.itens.add(item);
	}
	
	public void adiciona(Item... itens){
		for(Item item : itens) this.itens.add(item);
	}

	
	public double maiorValor() {
		if(itens.size() == 0) return 0;
		
		double maior = itens.get(0).getValorTotal();
		for(Item item : itens) {
			if(maior < item.getValorTotal()) {
				maior = item.getValorTotal();
			}
		}
		return maior;
	}

}//class CarrinhoDeCompras
