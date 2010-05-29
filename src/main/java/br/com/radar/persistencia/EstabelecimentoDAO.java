package br.com.radar.persistencia;

import java.util.List;

import org.hibernate.Session;

import br.com.radar.negocio.dominio.Estabelecimento;

public class EstabelecimentoDAO extends AbstractDAO {

	public List<Estabelecimento> obterEstabelecimentos() {
		return (List<Estabelecimento>) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Estabelecimento e ORDER BY e.id");
	}
	
	public Estabelecimento gravar(Estabelecimento estabelecimento) {
		return (Estabelecimento) executar(estabelecimento, ACAO_CRUD.GRAVAR, null);
	}
	
	public void apagar(Estabelecimento estabelecimento) {
		executar(estabelecimento, ACAO_CRUD.EXCLUIR, null);
	}
	
	/*
	 * Após ler este artigo
	 * http://www.javalobby.org/java/forums/t20533.html
	 * 
	 * Sobrescrevi executarConsulta para já carregar Endereco, apenas 
	 * para confirmar se de fato era esta a causa do LazyInitializationException
	 * 
	 * Resultado:
	 * org.hibernate.exception.SQLGrammarException: could not load an entity: 
	 * [br.com.radar.negocio.dominio.Endereco#1]
	 * 
	 * Teoria: erro de configuração em Estabelecimentos.hbm.xml
	 * 
	 * Resolvido. De fato, era erro de configuração em Estabelecimentos.hbm.xml
	 * 
	 * Agora funciona, embora precariamente. Carregar Enderecos dentro de Estabelecimentos
	 * não me parece a forma correta de resolver o problema.
	 * 
	*/
	/*
	
	// Temporariamente desnecessário, Lazy Loading está desativado
	protected <T> List<T> executarConsulta(Session session, String query) {
		
		List<T> estabelecimentos = (List<T>) session.createQuery(query).list();
		
		for (T e : estabelecimentos){
			((Estabelecimento)e).getEndereco().getLogradouro();
			((Estabelecimento)e).getEndereco().getNumero();
		}
		
		return estabelecimentos;
	}
	*/
}