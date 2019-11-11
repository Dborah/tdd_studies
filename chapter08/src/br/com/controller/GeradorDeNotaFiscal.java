package br.com.controller;

import java.util.List;
import br.com.model.AcaoAposGerarNota;
import br.com.model.NotaFiscal;
import br.com.model.Pedido;
import br.com.model.Relogio;
import br.com.model.RelogioDoSistema;
import br.com.model.Tabela;


/*	Agora a classe GeradorDeNotaFiscal não está mais fortemente
	acoplada a uma ação concreta, mas sim a uma lista qualquer de ações. A chance
	dela sofrer uma alteração propagada por uma dependência é bem menor. Além do
	mais, a evolução dessa classe passa a ser natural: basta passar mais itens na lista
	de ações, que ela as executará. Não há mais a necessidade de alterar a classe para
	adicionar um novo comportamento. Em orientação a objetos, a ideia de estendermos
	o comportamento de uma classe sem alterar seu código é conhecido como Princípio
	do Aberto-Fechado, ou OCP (Open-Closed Principle).
 */
public class GeradorDeNotaFiscal {
	
	private final List<AcaoAposGerarNota> acoes;
	private final Relogio relogio;
	private Tabela tabela;
	

	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Relogio relogio) {
		this.acoes = acoes;
		this.relogio = relogio;
	}
	
	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Relogio relogio, Tabela tabela) {
		this.acoes = acoes;
		this.relogio = relogio;
		this.tabela = tabela;
	}
	
	
	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Tabela tabela) {
		this(acoes, new RelogioDoSistema(), tabela);
	}
	
	//construitor sem relogio para não quebrar o resto do sistema
	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
		this(acoes, new RelogioDoSistema());
	}
	
	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(), pedido.getValorTotal() * tabela.paravalor(pedido.getValorTotal()), relogio.hoje());;
		
		for(AcaoAposGerarNota acao: acoes) {
			acao.executa(nf);
		}
		return nf;
	}
}//class GeradorDeNotaFiscal
