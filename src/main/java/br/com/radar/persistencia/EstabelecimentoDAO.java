package br.com.radar.persistencia;

import java.util.List;
import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.negocio.dominio.Endereco;

public class EstabelecimentoDAO extends AbstractDAO {

	public List<Estabelecimento> obterEstabelecimentos() {
		return (List<Estabelecimento>) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Estabelecimento p ORDER BY p.id");
	}
	
	public Estabelecimento gravar(Estabelecimento estabelecimento) {
		return (Estabelecimento) executar(estabelecimento, ACAO_CRUD.GRAVAR, null);
	}
	
	public void apagar(Estabelecimento estabelecimento) {
		executar(estabelecimento, ACAO_CRUD.EXCLUIR, null);
	}	
	
	/*
	 * As coisas come�aram a n�o fazer muito sentido depois de um tempo.
	 * Um DAO pra cada entidade? O que viria depois? Um Service pra cada um tamb�m?
	 * Muito c�digo duplicado. Eu sabia que estava fazendo algo errado, s� n�o sabia o qu�.
	 * 
	 * Comecei a formular duas hip�teses:
	 * 
	 * 1) Um DAO �nico (Estabelecimento), e este gerencia tudo (bagun�a warning?).
	 * 2) Um DAO pra cada entidade, por�m um �nico Service. Coerente, mas ainda preocupante.
	 * 
	 * Ainda n�o ficou claro tamb�m o que o Hibernate espera que eu fa�a sobre os mapeamentos.
	 * 
	 * Os m�todos a seguir representam minha primeira tentativa (hip�tese #1) de descobrir 
	 * a melhor solu��o.
	 * 
	 */
	
	public Endereco obterEndereco(Estabelecimento estabelecimento) {
		
		return (Endereco) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Endereco");
	}
}
