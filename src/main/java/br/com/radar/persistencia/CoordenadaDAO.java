package br.com.radar.persistencia;

import java.util.List;
import br.com.radar.negocio.dominio.Coordenada;

public class CoordenadaDAO extends AbstractDAO {

	public List<Coordenada> obterCoordenadas() {
		return (List<Coordenada>) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Coordenada c ORDER BY c.id");
	}
	
	public Coordenada gravar(Coordenada coordenada) {
		return (Coordenada) executar(coordenada, ACAO_CRUD.GRAVAR, null);
	}
	
	public void apagar(Coordenada coordenada) {
		executar(coordenada, ACAO_CRUD.EXCLUIR, null);
	}	
}
