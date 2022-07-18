package com.ServletFilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MobFilter
 */
@WebFilter("/MobileFilter")
public class MobFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MobFilter() {
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
		PrintWriter pw=response.getWriter();
		try {

			long mob = Long.parseLong(request.getParameter("mobile"));
			chain.doFilter(request, response);
		} catch (Exception e) {
			// pass the request along the filter chain
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			pw.println("Invalid number");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
