package br.com.teste.negocio.servico.pessoa;

import java.util.List;

import br.com.teste.negocio.dominio.pessoa.Pessoa;
import br.com.teste.persistencia.pessoa.PessoaDAO;

/**
 * Em java, é um pattern (padrão) considerar que a camada de negócio (que tem as
 * regras de negócio) seja chamada de camada Service (de serviço)
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
