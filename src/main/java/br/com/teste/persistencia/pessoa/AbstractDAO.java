package br.com.teste.persistencia.pessoa;

import org.hibernate.SessionFactory;
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

	/**
	 * Getter, para os que herdam
	 * 
	 * @return Session factory, para que as classes filha possam criar sessions
	 */
	public SessionFactory getSessionFactory() {
		return sf;
	}

}
