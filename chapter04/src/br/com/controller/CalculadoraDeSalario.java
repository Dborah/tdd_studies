package br.com.controller;

import br.com.model.Cargo;
import br.com.model.Funcionario;

public class CalculadoraDeSalario {
	
	public double calculaSalario(Funcionario funcionario) {
		if(funcionario.getSalario() > 3000) {
			return funcionario.getSalario() * 0.8;
		}
		return funcionario.getSalario() * 0.9;
	}

}//class CalculadoraDeSalario
