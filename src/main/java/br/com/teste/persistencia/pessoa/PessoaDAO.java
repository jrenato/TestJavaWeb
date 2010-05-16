package br.com.teste.persistencia.pessoa;

import java.util.List;

import br.com.teste.negocio.dominio.pessoa.Pessoa;

public class PessoaDAO extends AbstractDAO {

	/**
	 * Obtem a lista de pessoas do sistema
	 * 
	 * @return Lista de pessoas do sistema
	 */
	public List<Pessoa> obterPessoas() {
		return (List<Pessoa>) executar(null, ACAO_CRUD.CONSULTAR,
				"FROM Pessoa p ORDER BY p.id");
	}

	/**
	 * Cria uma entidade, ou atualiza uma entidade já existente (no caso,
	 * pessoa)
	 * 
	 */
	public Pessoa gravar(Pessoa pessoa) {
		return (Pessoa) executar(pessoa, ACAO_CRUD.GRAVAR, null);
	}

	/**
	 * Apaga uma entidade (no caso, pessoa)
	 * 
	 */
	public void apagar(Pessoa pessoa) {
		executar(pessoa, ACAO_CRUD.EXCLUIR, null);
	}
}
