package br.com.radar.persistencia;

import java.util.List;
import br.com.radar.negocio.dominio.Estabelecimento;
import br.com.radar.negocio.dominio.Endereco;

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
}