package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
	
	private String cliente;
	private double valorTotal;
	private boolean pago;
	private List<Pagamento> pagamentos;
	
	public Fatura(String cliente, double valor) {
		this.cliente = cliente;
		this.valorTotal =  valor;
		pagamentos = new ArrayList<>();
	}
	

	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	public void adicionaPagamento(Pagamento pagamento) {
		this.pagamentos.add(pagamento);
		
		double valorTotal = 0;
		
		for(Pagamento p : pagamentos)
			valorTotal += p.getValor();
		
		if(valorTotal >= this.valorTotal)
			this.pago = true;
	}
	
	

}//class Fatura
