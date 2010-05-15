package br.com.teste.persistencia.pessoa;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO {
	private static final SessionFactory sf;

	/*
	 * � preciso haver um session factory para gerar as sessions. Cada
	 * sessionFactory � pesado, de forma que deve haver apenas um por aplica��o
	 * para cada banco de dados sendo utilizado. J� as sessions s�o lightweight.
	 * 
	 * Esse conceito de session � diferente do conceito de sess�o utilizado para
	 * web (como forma de manter estado entre as p�ginas). A session do
	 * Hibernate � um objeto para persistir e obter dados.
	 */
	static {
		Configuration cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
	}

	protected enum ACAO_CRUD {
		CONSULTAR, EXCLUIR, GRAVAR
	}

	/**
	 * Getter, para os que herdam
	 * 
	 * @return Session factory, para que as classes filha possam criar sessions
	 */
	public SessionFactory getSessionFactory() {
		return sf;
	}

	protected <E> Object executar(E entidade, ACAO_CRUD acao, String query) {
		if (acao == null)
			throw new IllegalArgumentException("A��o n�o informada");

		Session s = null;
		Transaction tx = null;
		Object retorno = null;

		try {
			try {
				/*
				 * toda a comunica��o com o banco no hibernate � feita atrav�s
				 * de uma session; quem gera a session � uma session factory,
				 * que � instanciada quando a aplica��o sobe
				 */
				s = getSessionFactory().openSession();

				// toda a��o do hibernate exige uma transa��o
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
		/*
		 * HQL - sintaxe especifica do Hibernate, que ele muda para a SQL
		 * relativa ao banco que se est� usando
		 */
		return (List<T>) session.createQuery(query).list();
	}

	protected <T> T executarGravacao(Session session, T entidade) {
		/*
		 * Transient instances may be made persistent by calling save(),
		 * persist() or saveOrUpdate(). Persistent instances may be made
		 * transient by calling delete(). Any instance returned by a get() or
		 * load() method is persistent. Detached instances may be made
		 * persistent by calling update(), saveOrUpdate(), lock() or
		 * replicate(). The state of a transient or detached instance may also
		 * be made persistent as a new persistent instance by calling merge().
		 * 
		 * save() and persist() result in an SQL INSERT, delete() in an SQL
		 * DELETE and update() or merge() in an SQL UPDATE. Changes to
		 * persistent instances are detected at flush time and also result in an
		 * SQL UPDATE. saveOrUpdate() and replicate() result in either an INSERT
		 * or an UPDATE.
		 * 
		 * Fonte:
		 * http://docs.jboss.org/hibernate/stable/core/api/org/hibernate/Session
		 * .html
		 * 
		 * Baseado na informa��o acima, os m�todos deletar(Pessoa pessoa) e
		 * atualizar(Pessoa pessoa) teriam c�digo id�ntico ao gravar(Pessoa
		 * pessoa), a diferen�a sendo apenas a pr�xima linha - s.merge(pessoa).
		 * 
		 * Gravar() engloba tanto atualiza��o quanto cria��o de uma nova
		 * entidade. O hibernate serve para isto!
		 * 
		 * Duplica��o de c�digo necess�ria? Nunca, jamais!
		 */
		return (T) session.merge(entidade);
	}

	protected <T> void executarExclusao(Session session, T entidade) {
		session.delete(entidade);
	}

}
