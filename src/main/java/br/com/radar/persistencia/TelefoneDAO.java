package br.com.radar.persistencia;

import java.util.List;
import br.com.radar.negocio.dominio.Telefone;

public class TelefoneDAO extends AbstractDAO {

	public List<Telefone> obterTelefones() {
		return (List<Telefone>) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Telefone t ORDER BY t.id");
	}
	
	public Telefone gravar(Telefone telefone) {
		return (Telefone) executar(telefone, ACAO_CRUD.GRAVAR, null);
	}
	
	public void apagar(Telefone telefone) {
		executar(telefone, ACAO_CRUD.EXCLUIR, null);
	}	
}
