package formHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormHandling
 */
@WebServlet("/FormHandling")
public class FormHandling extends HttpServlet {
	public FormHandling() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<form action='FormHandling'>");
		pw.println("<input type=\"number\" name=\"num1\"><br>");
		pw.println("<input type=\"number\" name=\"num2\"><br>");
		pw.println("<input type=\"submit\" name=\"btn\" value=\"Add\">");
		pw.println("<input type=\"submit\" name=\"btn\" value=\"Sub\">");
		pw.println("<input type=\"submit\" name=\"btn\" value=\"Mul\">");
		pw.println("<input type=\"submit\" name=\"btn\" value=\"Div\">");
		pw.println("</form>");
		pw.println("</body><html>");
		if (request.getParameter("btn") != null) {
			if(request.getParameter("btn").equals("Add"))
			{
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			pw.println("Sum is " + (num1 + num2));
			}
			else if(request.getParameter("btn").equals("Sub"))
			{
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			pw.println("Sub is " + (num1 - num2));
			}
			else if(request.getParameter("btn").equals("Mul"))
			{
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			pw.println("Mul is " + (num1 * num2));
			}
			else if(request.getParameter("btn").equals("Div"))
			{
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			pw.println("Div is " + (num1 / num2));
			}
		}
	}

}
