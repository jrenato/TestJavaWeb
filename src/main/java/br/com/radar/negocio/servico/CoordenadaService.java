package br.com.radar.negocio.servico;

import java.util.List;

import br.com.radar.negocio.dominio.Coordenada;
import br.com.radar.persistencia.CoordenadaDAO;

public class CoordenadaService {
	
	private CoordenadaDAO coordenadaDAO;
	
	public CoordenadaService() {
		coordenadaDAO = new CoordenadaDAO();
	}
	
	public List<Coordenada> obterCoordenadas() {
		return coordenadaDAO.obterCoordenadas(); 
	}
	
	public void gravar(Coordenada coordenada) {
		coordenadaDAO.gravar(coordenada);
	}
	
	public void apagar(Coordenada coordenada) {
		coordenadaDAO.apagar(coordenada);
	}
}
