package br.com.controller;

import br.com.model.Funcionario;
import br.com.model.RegraDeCalculo;

public class QuinzeOuVinteCincoPorCento implements RegraDeCalculo{

	@Override
	public double calcula(Funcionario funcionario) {
		if(funcionario.getSalario() < 2500) {
			return funcionario.getSalario() * 0.85;
		}
		return funcionario.getSalario() * 0.75;
	}

}//QuinzeOuVinteCincoPorCento
