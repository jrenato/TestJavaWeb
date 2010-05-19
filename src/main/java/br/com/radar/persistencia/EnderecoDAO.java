package br.com.radar.persistencia;

import java.util.List;
import br.com.radar.negocio.dominio.Endereco;

public class EnderecoDAO extends AbstractDAO {

	public List<Endereco> obterEnderecos() {
		return (List<Endereco>) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Endereco p ORDER BY p.id");
	}
	
	public Endereco gravar(Endereco endereco) {
		return (Endereco) executar(endereco, ACAO_CRUD.GRAVAR, null);
	}
	
	public void apagar(Endereco endereco) {
		executar(endereco, ACAO_CRUD.EXCLUIR, null);
	}	
}
