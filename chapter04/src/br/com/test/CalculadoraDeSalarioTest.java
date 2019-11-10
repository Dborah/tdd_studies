package br.com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.controller.CalculadoraDeSalario;
import br.com.model.Cargo;
import br.com.model.Funcionario;

public class CalculadoraDeSalarioTest {
	
	/*
	 * O primeiro cenário a ser testado será de desenvolvedores com salário
	 * menor do que R$ 3000,00. O Desconto será de 10%. Portanto, se o desenvolvedor
	 * ganhar R$ 1500,00, seu salário com o desconto deve ser de R$ 1350,00. (1500 * 90%).
	 */
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite() {
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Mauricio", 1500.0, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(1500.0 * 0.9, salario, 0.00001);
		
	}
	
	//Testa agora desenvolvedores que recebem acima do limite (R$ 3500,00) e tem desconto de 20%.
	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite() {
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		
		Funcionario desenvolvedor = new Funcionario ("Mauricio", 4000.0, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		assertEquals(4000.0 * 0.8, salario, 0.00001);
	}
	
	/*
	//Testa agora dbas que recebem abaixo do limite (R$ 1500,00) e tem desconto de 15%.
	@Test
	public void deveCalcularSalarioParaDBAsComSalarioAbaixoDoLimite() {
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		
		Funcionario dba = new Funcionario("Mauricio", 500.0, Cargo.DBA);
		
		double salario = calculadora.calculaSalario(dba);
		assertEquals(500.0 * 0.85, salario, 0.00001);
	}
	*/
}//class CalculadoraDeSalarioTest
