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
				 * toda a comunicação com o banco no hibernate é feita através
				 * de uma session; quem gera a session é uma session factory,
				 * que é instanciada quando a aplicação sobe
				 */
				s = getSessionFactory().openSession();

				// toda ação do hibernate exige uma transação
				tx = s.beginTransaction();

				/*
				 * HQL - sintaxe especifica do Hibernate, que ele muda para a
				 * SQL relativa ao banco que se está usando
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
				/*
				 * Transient instances may be made persistent by calling save(), 
				 * persist() or saveOrUpdate(). Persistent instances may be made 
				 * transient by calling delete(). Any instance returned by a get() 
				 * or load() method is persistent. Detached instances may be made
				 * persistent by calling update(), saveOrUpdate(), lock() or replicate().
				 * The state of a transient or detached instance may also be made persistent 
				 * as a new persistent instance by calling merge().
				 * 
				 * save() and persist() result in an SQL INSERT, delete() in an SQL DELETE 
				 * and update() or merge() in an SQL UPDATE. Changes to persistent instances 
				 * are detected at flush time and also result in an SQL UPDATE. saveOrUpdate() 
				 * and replicate() result in either an INSERT or an UPDATE.
				 *
				 * Fonte: http://docs.jboss.org/hibernate/stable/core/api/org/hibernate/Session.html
				 * 
				 * Baseado na informação acima, os métodos deletar(Pessoa pessoa) e 
				 * atualizar(Pessoa pessoa) teriam código idêntico ao gravar(Pessoa pessoa),
				 * a diferença sendo apenas a próxima linha - s.merge(pessoa).
				 * 
				 * Aliás, atualizar() e gravar() não poderiam ser o mesmo método?
				 * 
				 * Duplicação de código necessária?
				 */
				
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
	
	public void apagar(Pessoa pessoa) {
		Session s = null;
		Transaction tx = null;

		try {
			try {
				s = getSessionFactory().openSession();
				tx = s.beginTransaction();
					
				s.delete(pessoa);
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
