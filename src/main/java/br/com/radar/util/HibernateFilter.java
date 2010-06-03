package br.com.radar.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HibernateFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
			HibernateUtil.commitTransaction();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}

}
