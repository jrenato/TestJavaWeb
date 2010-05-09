package br.com.teste.negocio.servico.pessoa;

import java.util.List;

import br.com.teste.negocio.dominio.pessoa.Pessoa;
import br.com.teste.persistencia.pessoa.PessoaDAO;

/**
 * Em java, � um pattern (padr�o) considerar que a camada de neg�cio (que tem as
 * regras de neg�cio) seja chamada de camada Service (de servi�o)
 */

public class PessoaService {
	
	private PessoaDAO pessoaDAO;
	
	public PessoaService() {
		 pessoaDAO = new PessoaDAO();
	}
	
	/**
	 * Obtem a lista de pessoas do sistema
	 * 
	 * @return Lista de pessoas do sistema
	 */
	public List<Pessoa> obterPessoas() {
		return pessoaDAO.obterPessoas(); 
	}
	
	public void gravar(Pessoa pessoa) {
		pessoaDAO.gravar(pessoa);
	}
}
