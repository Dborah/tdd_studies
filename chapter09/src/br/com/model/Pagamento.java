package br.com.model;

public class Pagamento {
	private double valor;
	private MeioDePagamento formaPagamento;
	
	public Pagamento(double valor, MeioDePagamento formaPagamento) {
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public MeioDePagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(MeioDePagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}	
	

}//class Pagamento
