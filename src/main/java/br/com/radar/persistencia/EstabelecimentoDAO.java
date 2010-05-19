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
	 * As coisas começaram a não fazer muito sentido depois de um tempo.
	 * Um DAO pra cada entidade? O que viria depois? Um Service pra cada um também?
	 * Muito código duplicado. Eu sabia que estava fazendo algo errado, só não sabia o quê.
	 * 
	 * Comecei a formular duas hipóteses:
	 * 
	 * 1) Um DAO único (Estabelecimento), e este gerencia tudo (bagunça warning?).
	 * 2) Um DAO pra cada entidade, porém um único Service. Coerente, mas ainda preocupante.
	 * 
	 * Ainda não ficou claro também o que o Hibernate espera que eu faça sobre os mapeamentos.
	 * 
	 * Os métodos a seguir representam minha primeira tentativa (hipótese #1) de descobrir 
	 * a melhor solução.
	 * 
	 */
	
	public Endereco obterEndereco(Estabelecimento estabelecimento) {
		
		return (Endereco) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Endereco");
	}
}
