package br.com.radar.apresentacao.managedbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.radar.negocio.dominio.Endereco;
import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.negocio.dominio.Telefone;
import br.com.radar.negocio.servico.EstabelecimentoService;

public class EstabelecimentoBean {

	private List<Estabelecimento> estabelecimentos;
	private DataModel<Estabelecimento> estabelecimentosModel;
	private EstabelecimentoService estabelecimentoService;
	private Estabelecimento estabelecimentoSelecionado;

	public EstabelecimentoBean() {
		estabelecimentoService = new EstabelecimentoService();
		estabelecimentosModel = new ListDataModel<Estabelecimento>();
	}

	public DataModel<Estabelecimento> getEstabelecimentos() {
		estabelecimentos = estabelecimentoService.obterEstabelecimentos();

		/*
		 * Ideia retirada daqui http://www.guj.com.br/posts/list/78781.java Mas
		 * não deu certo, a sessão continua fechada quando chega aqui O problema
		 * precisa ser resolvido em EstabelecimentoDAO, e não aqui
		 * 
		 * Error reading 'estabelecimentos' root cause
		 * org.hibernate.LazyInitializationException: could not initialize proxy
		 * - no Session
		 */

		/*
		 * for (Estabelecimento e : estabelecimentos){
		 * e.getEndereco().getLogradouro(); e.getEndereco().getNumero(); }
		 */

		estabelecimentosModel.setWrappedData(estabelecimentos);
		return estabelecimentosModel;
	}

	public DataModel<Telefone> getTelefones() {
		DataModel<Telefone> l = new ListDataModel<Telefone>();
		Set<Telefone> telefones = estabelecimentoSelecionado.getEndereco()
				.getTelefone();
		ArrayList al = new ArrayList<Telefone>(telefones);
		l.setWrappedData(al);
		return l;
	}

	public Estabelecimento getEstabelecimentoSelecionado() {
		return estabelecimentoSelecionado;
	}

	public String selecionar() {
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel
				.getRowData();
		return "estabelecimentoSelecionado";
	}

	public String gravar() {
		estabelecimentoService.gravar(estabelecimentoSelecionado);
		// retorna chave para a navegação
		return "estabelecimentoAtualizado";
	}

	public String apagar() {
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel
				.getRowData();
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
