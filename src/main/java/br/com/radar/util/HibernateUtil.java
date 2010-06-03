package br.com.radar.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final ThreadLocal<Session> threadSession;
	private static final ThreadLocal<Transaction> threadTransaction;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		threadSession = new ThreadLocal<Session>();
		threadTransaction = new ThreadLocal<Transaction>();
	}

	public static Session getSession() {
		Session session = threadSession.get();
		try {
			if (session == null) {
				session = sessionFactory.openSession();
				threadSession.set(session);
			}
		} catch (HibernateException ex) {
			throw ex;
		}
		return session;
	}

	public static void closeSession() {
		try {
			Session session = threadSession.get();
			threadSession.set(null);
			if (session != null && session.isOpen())
				session.close();
		} catch (HibernateException ex) {
			throw ex;
		}
	}

	public static void beginTransaction() {
		Transaction transaction = threadTransaction.get();
		try {
			if (transaction == null) {
				transaction = getSession().beginTransaction();
				threadTransaction.set(transaction);
			}
		} catch (HibernateException ex) {
			throw ex;
		}
	}

	public static void commitTransaction() {
		Transaction transaction = threadTransaction.get();
		try {
			if (transaction != null && !transaction.wasCommitted()
					&& !transaction.wasRolledBack()) {
				transaction.commit();
			}
			threadTransaction.set(null);
		} catch (HibernateException ex) {
			rollbackTransaction();
			throw ex;
		}
	}

	public static void rollbackTransaction() {
		Transaction transaction = threadTransaction.get();
		try {
			threadTransaction.set(null);
			if (transaction != null && !transaction.wasCommitted()
					&& !transaction.wasRolledBack()) {
				transaction.rollback();
			}
		} catch (HibernateException ex) {
			throw ex;
		} finally {
			closeSession();
		}
	}
}
