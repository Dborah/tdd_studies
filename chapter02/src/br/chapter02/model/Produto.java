package br.chapter02.model;

public class Produto {
	private long id;
	private String nome;
	private String descricao;
	private double valor;
	
	public Produto() {}
	
	public Produto(String nome, String descricao, double valor) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}//class Produto
