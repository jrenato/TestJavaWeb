package br.com.teste.persistencia.pessoa;

import org.hibernate.SessionFactory;
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

	/**
	 * Getter, para os que herdam
	 * 
	 * @return Session factory, para que as classes filha possam criar sessions
	 */
	public SessionFactory getSessionFactory() {
		return sf;
	}

}
