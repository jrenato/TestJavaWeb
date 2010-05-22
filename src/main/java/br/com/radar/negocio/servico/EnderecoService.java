package br.com.radar.negocio.servico;

import java.util.List;

import br.com.radar.negocio.dominio.Endereco;
import br.com.radar.persistencia.EnderecoDAO;

public class EnderecoService {
	
	private EnderecoDAO enderecoDAO;
	
	public EnderecoService() {
		enderecoDAO = new EnderecoDAO();
	}
	
	public List<Endereco> obterEnderecos() {
		return enderecoDAO.obterEnderecos(); 
	}
	
	public void gravar(Endereco endereco) {
		enderecoDAO.gravar(endereco);
	}
	
	public void apagar(Endereco endereco) {
		enderecoDAO.apagar(endereco);
	}
}
