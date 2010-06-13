package br.com.radar.apresentacao.managedbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
	
	private Set<Telefone> telefones;
	private DataModel<Telefone> telefonesModel;
	private Telefone telefoneSelecionado;

	public EstabelecimentoBean() {
		estabelecimentoService = new EstabelecimentoService();
		estabelecimentosModel = new ListDataModel<Estabelecimento>();
	}

	public DataModel<Estabelecimento> getEstabelecimentos() {
		estabelecimentos = estabelecimentoService.obterEstabelecimentos();
		estabelecimentosModel.setWrappedData(estabelecimentos);
		return estabelecimentosModel;
	}

	public DataModel<Telefone> getTelefones() {
		telefonesModel = new ListDataModel<Telefone>();
		telefones = estabelecimentoSelecionado.getEndereco()
				.getTelefone();
		ArrayList<Telefone> al = new ArrayList<Telefone>(telefones);
		telefonesModel.setWrappedData(al);
		return telefonesModel;
	}

	public Estabelecimento getEstabelecimentoSelecionado() {
		return estabelecimentoSelecionado;
	}
	
	public Telefone getTelefoneSelecionado() {
		return telefoneSelecionado;
	}
 
	public void setEstabelecimentoSelecionado(Estabelecimento estabelecimentoSelecionado) {
		this.estabelecimentoSelecionado = estabelecimentoSelecionado;
	}
	
	public void setTelefoneSelecionado (Telefone telefoneSelecionado) {
		this.telefoneSelecionado = telefoneSelecionado;
	}

	public String selecionar() {
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel
				.getRowData();
		return "estabelecimentoSelecionado";
	}
	
	public String selecionarTelefone() {
		telefoneSelecionado = (Telefone) telefonesModel
				.getRowData();
		return "telefoneSelecionado";
	}

	public String gravar() {
		estabelecimentoService.gravar(estabelecimentoSelecionado);
		// retorna chave para a navegação
		return "estabelecimentoAtualizado";
	}
	
	public String gravarTelefone() {
		// estabelecimentoService.gravar(estabelecimentoSelecionado);
		// retorna chave para a navegação
		return "telefoneAtualizado";
	}

	public String apagar() {
		this.estabelecimentoSelecionado = (Estabelecimento) estabelecimentosModel
				.getRowData();
		estabelecimentoService.apagar(estabelecimentoSelecionado);

		// retorna chave para a navegação
		return "estabelecimentoApagado";
	}
	
	public String apagarTelefone() {
		telefoneSelecionado = (Telefone) telefonesModel
			.getRowData();
		telefones.remove(telefoneSelecionado);
		// retorna chave para a navegação
		return "telefoneApagado";
	}
	

	public String criar() {
		this.estabelecimentoSelecionado = new Estabelecimento();
		Endereco endereco = new Endereco();
		endereco.setTelefone(new HashSet<Telefone>());
		estabelecimentoSelecionado.setEndereco(endereco);
		// retorna chave para a navegação
		return "estabelecimentoSelecionado";
	}
	
	public String criarTelefone() {
		Telefone telefone = new Telefone();
		this.telefoneSelecionado = telefone;
		telefones.add(telefone);
		return "telefoneSelecionado";
	}
}
