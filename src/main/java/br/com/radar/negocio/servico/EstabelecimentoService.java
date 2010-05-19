package br.com.radar.negocio.servico;

import java.util.List;

import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.persistencia.EstabelecimentoDAO;

/**
 * Em java, é um pattern (padrão) considerar que a camada de negócio (que tem as
 * regras de negócio) seja chamada de camada Service (de serviço)
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
