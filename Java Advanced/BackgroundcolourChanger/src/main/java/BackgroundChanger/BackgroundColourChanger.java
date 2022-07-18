package BackgroundChanger;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BackgroundColourChanger
 */
@WebServlet("/BackgroundColourChanger")
public class BackgroundColourChanger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackgroundColourChanger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		if(request.getParameter("btn")!=null)
		{
			String colour=request.getParameter("colour");
			pw.println("<html><body bgcolor='"+colour+"'>");
			pw.println("<form action='BackgroundColourChanger' method='get'>");
			pw.println("<input type='text' name='colour'><br>");
			pw.println("<input type='submit' name='btn' value='change'>");
			pw.println("</form></body></html>");
		}
		else
		{
			
			pw.println("<html><body>");
			pw.println("<form action='BackgroundColourChanger' method='get'>");
			pw.println("<input type='text' name='t1'><br>");
			pw.println("<input type='submit' name='btn' value='change'>");
			pw.println("</form></body></html>");
		}

		

		}
	}


