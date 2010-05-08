package br.com.teste.persistencia.pessoa;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.teste.negocio.dominio.pessoa.Pessoa;

public class PessoaDAO extends AbstractDAO {

	/**
	 * Obtem a lista de pessoas do sistema
	 * 
	 * @return Lista de pessoas do sistema
	 */
	public List<Pessoa> obterPessoas() {
		Session s = null;
		Transaction tx = null;
		List<Pessoa> l = null;

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

				/*
				 * HQL - sintaxe especifica do Hibernate, que ele muda para a
				 * SQL relativa ao banco que se est� usando
				 */
				l = s.createQuery("FROM Pessoa p ORDER BY p.id")
						.list();

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

		return l;
	}

	/**
	 * Grava uma entidade (no caso, pessoa)
	 * 
	 */
	public void gravar(Pessoa pessoa) {
		Session s = null;
		Transaction tx = null;

		try {
			try {
				s = getSessionFactory().openSession();
				tx = s.beginTransaction();
				s.merge(pessoa);
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

		return;
	}
}
