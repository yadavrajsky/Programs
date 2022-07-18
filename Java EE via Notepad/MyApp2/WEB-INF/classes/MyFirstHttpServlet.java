import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class MyFirstHttpServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter();
    pw.println("<html><body>");
    for (int i = 1; i <= 6; i++) {
      pw.println("<h" + i + ">" + "Heading" + "</h" + i + ">");
    }
    pw.println("</body></html>");
  }
}
