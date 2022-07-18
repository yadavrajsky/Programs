package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class MyFirstCalc extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<form action='calc' Method='post'>");
		pw.println("<input type='text' name='t1'><br>");
		pw.println("<input type='text' name='t2'><br>");
		pw.println("<input type='submit' name='btn' value='ADD'>");
		pw.println("<input type='submit' name='btn' value='SUB'>");
		pw.println("<input type='submit' name='btn' value='MUL'>");
		pw.println("<input type='submit' name='btn' value='DIV'>");
		pw.println("</form></body></html>");
		
		if(request.getParameter("btn")!=null)
		{
			pw.println("Hello");
			int x=Integer.parseInt(request.getParameter("t1"));
			int y=Integer.parseInt(request.getParameter("t2"));
			
			if(request.getParameter("btn").equals("ADD"))
			{
				pw.println("Sum is:"+(x+y));
				
			}
			else if(request.getParameter("btn").equals("SUB"))
			{
				pw.println("Subtraction is:"+ (x-y));
			}
			else if(request.getParameter("btn").equals("MUL"))
			{
				pw.println("Multiplication is:"+x*y);
			}
			else if(request.getParameter("btn")=="DIV")
			{
				pw.println("Division is:"+x/y);
			}
		}

	
	}
}