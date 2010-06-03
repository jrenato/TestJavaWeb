package br.com.radar.persistencia;

import java.util.List;

import br.com.radar.util.HibernateUtil;

public abstract class AbstractDAO {

	protected enum ACAO_CRUD {
		CONSULTAR, EXCLUIR, GRAVAR
	}

	protected <E> Object executar(E entidade, ACAO_CRUD acao, String query) {
		if (acao == null)
			throw new IllegalArgumentException("Ação não informada");
		Object retorno = null;

		try {
			HibernateUtil.beginTransaction();
			if (acao.equals(ACAO_CRUD.CONSULTAR)) {
				retorno = executarConsulta(query);
			} else if (acao.equals(ACAO_CRUD.GRAVAR)) {
				retorno = executarGravacao(entidade);
			} else if (acao.equals(ACAO_CRUD.EXCLUIR)) {
				executarExclusao(entidade);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return retorno;
	}

	protected <T> List<T> executarConsulta(String query) {

		return (List<T>) HibernateUtil.getSession().createQuery(query).list();
	}

	protected <T> T executarGravacao(T entidade) {

		return (T) HibernateUtil.getSession().merge(entidade);
	}

	protected <T> void executarExclusao(T entidade) {
		HibernateUtil.getSession().delete(entidade);
	}

}
