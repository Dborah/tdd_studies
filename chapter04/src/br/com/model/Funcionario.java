package br.com.model;

public class Funcionario {
	private String nome;
	private Cargo cargo;
	private double salario;
	
	public Funcionario(String nome, double salario, Cargo cargo) {
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public double getSalario() {
		return salario;
	}
}//class Funcionario
