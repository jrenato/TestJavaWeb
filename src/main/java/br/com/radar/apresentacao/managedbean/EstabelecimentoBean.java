package br.com.radar.apresentacao.managedbean;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.negocio.dominio.Endereco;
import br.com.radar.negocio.servico.EstabelecimentoService;

public class EstabelecimentoBean {

	private List<Estabelecimento> estabelecimentos;
	private DataModel<Estabelecimento> estabelecimentosModel = new ListDataModel<Estabelecimento>();
	private EstabelecimentoService estabelecimentoService;

	private Estabelecimento estabelecimentoSelecionado;

	public EstabelecimentoBean() {
		estabelecimentoService = new EstabelecimentoService();
	}

	public DataModel<Estabelecimento> getEstabelecimentos() {
		estabelecimentos = estabelecimentoService.obterEstabelecimentos();
				
		/*
		 *  Ideia retirada daqui
		 *  http://www.guj.com.br/posts/list/78781.java
		 *  Mas não deu certo, óbvio, a sessão continua fechada quando chega aqui
		 *  O problema precisa ser resolvido:
		 *  
		 *  1) Em EstabelecimentoDAO, ou
		 *  2) Na configuração do Hibernate sobre Lazy Loading
		 *  
 		 *  Error reading 'estabelecimentos'
		 *  root cause
		 *  org.hibernate.LazyInitializationException: could not initialize proxy - no Session
		 */ 

		/*
		for (Estabelecimento e : estabelecimentos){
			e.getEndereco().getLogradouro();
			e.getEndereco().getNumero();
		}
		*/
		
		estabelecimentosModel.setWrappedData(estabelecimentos);
		
		return estabelecimentosModel;
	}

	public Estabelecimento getEstabelecimentoSelecionado() {
		return estabelecimentoSelecionado;
	}

	public void setEstabelecimentoSelecionado(Estabelecimento estabelecimentoSelecionado) {
		this.estabelecimentoSelecionado = estabelecimentoSelecionado;
	}

	public String selecionar() {
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel.getRowData();
		return "estabelecimentoSelecionado";
	}

	public String gravar() {

		estabelecimentoService.gravar(estabelecimentoSelecionado);

		// retorna chave para a navegação
		return "estabelecimentoAtualizado";
	}
	
	public String apagar() {
		
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel.getRowData();
		estabelecimentoService.apagar(estabelecimentoSelecionado);

		// retorna chave para a navegação
		return "estabelecimentoApagado";
	}
	
	public String criar() {
		this.estabelecimentoSelecionado = new Estabelecimento();
		estabelecimentoSelecionado.setEndereco(new Endereco());
		
		// retorna chave para a navegação
		return "estabelecimentoSelecionado";		
	}
}
