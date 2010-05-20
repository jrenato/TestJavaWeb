package br.com.radar.apresentacao.managedbean;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.negocio.servico.EstabelecimentoService;

/**
 * No JSF, o Bean faz o papel de Controller (do modelo MVC), ou seja: ele recebe
 * as a��es realizadas pelo JSP e despacha as a��es para servi�os respectivos.
 * Num modelo simples, cada entidade (no caso, Pessoa), possui uma classe DAO
 * (de acesso a dados), uma classe de servi�o (de regras de negocio, e que se
 * comunica com o DAO) e um Bean. � um modelo que se aplica a boa parte das
 * data-centric application simples. No caso, existe um PessoaBean, que bate num
 * PessoaService, que bate num PessoaDAO, que conversa com o banco e retorna
 * para o PessoaService, que retorna para o PessoaBean, que exibe o status na
 * tela.
 * 
 * Esta � a base, mas existe forma muito mais elegante do que a que estamos
 * usando aqui, nas tr�s camadas. Com o tempo a gente vai trocando uma coisa por
 * outra, colocando frameworks, para tornar todo esse processo ainda mais
 * simples. Tem framework pra melhorar a interface (com ajax implicito e muito
 * facil de usar), para melhorar a integra��o entre as camadas, a navega��o
 * entre telas, e at� vai dar para tirar o DAO, se a gente quiser.
 * 
 * @author daniel
 * 
 */

public class EstabelecimentoBean {

	private List<Estabelecimento> estabelecimentos;
	private DataModel<Estabelecimento> estabelecimentosModel = new ListDataModel<Estabelecimento>();
	private EstabelecimentoService estabelecimentoService;

	// para edi��o
	private Estabelecimento estabelecimentoSelecionado;

	public EstabelecimentoBean() {
		estabelecimentoService = new EstabelecimentoService();
	}

	/**
	 * Obtem a lista de estabelecimentos do sistema, num formato de datamodel (para que
	 * possa iteragir com o modo de sele��o do datatable. No futuro, quando
	 * colocarmos outros frameworks, n�o vai ser preciso utilizar este datamodel
	 * (vai ser possivel utilizar o objeto diretamente no datatable)
	 * 
	 * @return Lista de estabelecimentos do sistema
	 */
	public DataModel<Estabelecimento> getEstabelecimentos() {
		estabelecimentos = estabelecimentoService.obterEstabelecimentos();
				
		/*
		 *  Ideia retirada daqui
		 *  http://www.guj.com.br/posts/list/78781.java
		 *  Mas n�o deu certo, a sess�o continua fechada quando chega aqui
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

	public void setPessoaSelecionada(Estabelecimento estabelecimentoSelecionado) {
		this.estabelecimentoSelecionado = estabelecimentoSelecionado;
	}

	public String selecionar() {
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel.getRowData();
		return "estabelecimentoSelecionado";
	}

	public String gravar() {

		estabelecimentoService.gravar(estabelecimentoSelecionado);

		// retorna chave para a navega��o
		return "estabelecimentoAtualizado";
	}
	
	public String apagar() {
		
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel.getRowData();
		estabelecimentoService.apagar(estabelecimentoSelecionado);

		// retorna chave para a navega��o
		return "estabelecimentoApagado";
	}
	
	public String criar() {
		this.estabelecimentoSelecionado = new Estabelecimento();
		
		// retorna chave para a navega��o
		return "estabelecimentoSelecionado";		
	}
}
