package br.com.radar.negocio.servico;

import java.util.List;

import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.persistencia.EstabelecimentoDAO;

public class EstabelecimentoService {
	
	private EstabelecimentoDAO estabelecimentoDAO;
	
	public EstabelecimentoService() {
		 estabelecimentoDAO = new EstabelecimentoDAO();
	}
	
	public List<Estabelecimento> obterEstabelecimentos() {
		return estabelecimentoDAO.obterEstabelecimentos(); 
	}
	
	public void gravar(Estabelecimento estabelecimento) {
		estabelecimentoDAO.gravar(estabelecimento);
	}
	
	public void apagar(Estabelecimento estabelecimento) {
		estabelecimentoDAO.apagar(estabelecimento);
	}
}
