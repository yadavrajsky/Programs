package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo
 */
@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String dt = sdf.format(new Date());
//	pw.println(dt);
		Cookie[] ckr = request.getCookies();
		Cookie ck = null;
		if (ckr != null) {
			for (Cookie c : ckr) {
				if (c.getName().equals("lastvisit")) {
					pw.println("Your last visit was at " + c.getValue());
					c.setValue(dt);
					ck = c;
					;

				}

			}
		} else {
			ck = new Cookie("lastvisit", dt);
			pw.println("Your first visit");

		}
		ck.setMaxAge(10);

		response.addCookie(ck);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
