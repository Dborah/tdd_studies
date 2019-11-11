package br.com.controller;

import java.util.List;

import br.com.model.Boleto;
import br.com.model.Fatura;
import br.com.model.MeioDePagamento;
import br.com.model.Pagamento;

public class ProcessadorDeBoletos {
	
	public void processa(List<Boleto> boletos, Fatura fatura) {
		for(Boleto boleto : boletos) {
			Pagamento pagamento = new Pagamento(boleto.getValor(), MeioDePagamento.BOLETO);
			fatura.adicionaPagamento(pagamento);
		}
	}

}//class ProcessadorDeBoletos 
