package com.basico.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Sesion
 */
@WebFilter(filterName="/Sesion", urlPatterns = "/zonaprivada.jsp")
public class Sesion implements Filter {

	/**
	 * Default constructor.
	 */
	public Sesion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// Para la session
		HttpServletRequest http = (HttpServletRequest) request;
		HttpSession session = http.getSession(false);

		System.out.println("FILTER");

		Object usuario = null;
		// Preguntamos por un objeto en la sesion
		if (session != null)
			usuario = session.getAttribute("user");

		if (session == null || usuario == null) {
			System.out.println("Session Invalid");
			try {
				http.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (ServletException e) {
			} catch (IOException e) {
			}
		} else
			System.out.println("Session valid");

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
