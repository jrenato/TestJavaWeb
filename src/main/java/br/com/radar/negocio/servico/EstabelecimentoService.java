package br.com.radar.negocio.servico;

import java.util.List;

import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.persistencia.EstabelecimentoDAO;

/**
 * Em java, � um pattern (padr�o) considerar que a camada de neg�cio (que tem as
 * regras de neg�cio) seja chamada de camada Service (de servi�o)
 */

public class EstabelecimentoService {
	
	private EstabelecimentoDAO estabelecimentoDAO;
	
	public EstabelecimentoService() {
		 estabelecimentoDAO = new EstabelecimentoDAO();
	}
	
	/**
	 * Obtem a lista de pessoas do sistema
	 * 
	 * @return Lista de pessoas do sistema
	 */
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
