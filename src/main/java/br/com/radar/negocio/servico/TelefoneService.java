package br.com.radar.negocio.servico;

import java.util.List;

import br.com.radar.negocio.dominio.Telefone;
import br.com.radar.persistencia.TelefoneDAO;

public class TelefoneService {
	
	private TelefoneDAO telefoneDAO;
	
	public TelefoneService() {
		telefoneDAO = new TelefoneDAO();
	}
	
	public List<Telefone> obterTelefones() {
		return telefoneDAO.obterTelefones(); 
	}
	
	public void gravar(Telefone telefone) {
		telefoneDAO.gravar(telefone);
	}
	
	public void apagar(Telefone telefone) {
		telefoneDAO.apagar(telefone);
	}
}
