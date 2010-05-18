package br.com.radar.persistencia;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO {
	private static final SessionFactory sf;

	static {
		Configuration cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
	}

	protected enum ACAO_CRUD {
		CONSULTAR, EXCLUIR, GRAVAR
	}

	public SessionFactory getSessionFactory() {
		return sf;
	}

	protected <E> Object executar(E entidade, ACAO_CRUD acao, String query) {
		if (acao == null)
			throw new IllegalArgumentException("Ação não informada");

		Session s = null;
		Transaction tx = null;
		Object retorno = null;

		try {
			try {

				s = getSessionFactory().openSession();

				tx = s.beginTransaction();

				if (acao.equals(ACAO_CRUD.CONSULTAR)) {
					retorno = executarConsulta(s, query);
				} else if (acao.equals(ACAO_CRUD.GRAVAR)) {
					retorno = executarGravacao(s, entidade);
				} else if (acao.equals(ACAO_CRUD.EXCLUIR)) {
					executarExclusao(s, entidade);
				}

				tx.commit();
			} catch (HibernateException ex) {
				tx.rollback();
				throw ex;
			} finally {
				if (s != null)
					s.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return retorno;
	}

	protected <T> List<T> executarConsulta(Session session, String query) {

		return (List<T>) session.createQuery(query).list();
	}

	protected <T> T executarGravacao(Session session, T entidade) {

		return (T) session.merge(entidade);
	}

	protected <T> void executarExclusao(Session session, T entidade) {
		session.delete(entidade);
	}

}
