package string.mapping.colours;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StringMappingColours
 */
@WebServlet("/StringMappingColours")
public class StringMappingColours extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StringMappingColours() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		String s = "bacadeah";
		String[] colours = { "red", "green", "cyan", "yellow", "pink", "blue", "orange", "indigo" };
		String colortemp;
		char[] lettersArr = s.toCharArray();
		char temp;
		int i = 0;
		while (i < lettersArr.length) {
			int j = i + 1;
			while (j < lettersArr.length) {
				if (lettersArr[i] < lettersArr[j]) {
					temp = lettersArr[j];
					colortemp = colours[j];
					lettersArr[j] = lettersArr[i];
					colours[j] = colours[i];
					lettersArr[i] = temp;
					colours[i] = colortemp;
				}
				j += 1;
			}
			i += 1;

		}
		for (int k = 0; k < lettersArr.length; k++) {
			pw.println("<span style='color:" + colours[k] + "'>" + lettersArr[k] + "</span>");
		}
		pw.println("</body></html>");
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
