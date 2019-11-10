package br.com.controller;

import br.com.model.Funcionario;
import br.com.model.RegraDeCalculo;

public class DezOuVintePorCento implements RegraDeCalculo {

	@Override
	public double calcula(Funcionario funcionario) {
		if(funcionario.getSalario() > 3000) {
			return funcionario.getSalario() * 0.8;
		}
		return funcionario.getSalario() * 0.9;
	}


}//class DezOuVintePorCento
