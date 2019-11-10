package br.com.model;

import br.com.controller.DezOuVintePorCento;
import br.com.controller.QuinzeOuVinteCincoPorCento;;

public enum Cargo {
	DESENVOLVEDOR (new DezOuVintePorCento()),
	DBA(new QuinzeOuVinteCincoPorCento()),
	TESTADOR(new QuinzeOuVinteCincoPorCento());
	
	
	private final RegraDeCalculo regra;
	
	private Cargo(RegraDeCalculo regra){
		this.regra = regra;
	}
	
	public RegraDeCalculo getRegra() {
		return regra;
	}

}//enum Cargo
