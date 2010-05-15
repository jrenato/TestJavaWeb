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
	 * É preciso haver um session factory para gerar as sessions. Cada
	 * sessionFactory é pesado, de forma que deve haver apenas um por aplicação
	 * para cada banco de dados sendo utilizado. Já as sessions são lightweight.
	 * 
	 * Esse conceito de session é diferente do conceito de sessão utilizado para
	 * web (como forma de manter estado entre as páginas). A session do
	 * Hibernate é um objeto para persistir e obter dados.
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
			throw new IllegalArgumentException("Ação não informada");

		Session s = null;
		Transaction tx = null;
		Object retorno = null;

		try {
			try {
				/*
				 * toda a comunicação com o banco no hibernate é feita através
				 * de uma session; quem gera a session é uma session factory,
				 * que é instanciada quando a aplicação sobe
				 */
				s = getSessionFactory().openSession();

				// toda ação do hibernate exige uma transação
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
		 * relativa ao banco que se está usando
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
		 * Baseado na informação acima, os métodos deletar(Pessoa pessoa) e
		 * atualizar(Pessoa pessoa) teriam código idêntico ao gravar(Pessoa
		 * pessoa), a diferença sendo apenas a próxima linha - s.merge(pessoa).
		 * 
		 * Gravar() engloba tanto atualização quanto criação de uma nova
		 * entidade. O hibernate serve para isto!
		 * 
		 * Duplicação de código necessária? Nunca, jamais!
		 */
		return (T) session.merge(entidade);
	}

	protected <T> void executarExclusao(Session session, T entidade) {
		session.delete(entidade);
	}

}
