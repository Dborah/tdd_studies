package br.com.controller;

import br.com.model.Cargo;
import br.com.model.Funcionario;

public class CalculadoraDeSalario {
	
	public double calculaSalario(Funcionario funcionario) {
		return funcionario.getCargo().getRegra().calcula(funcionario);
	}
	
	

}//class CalculadoraDeSalario
