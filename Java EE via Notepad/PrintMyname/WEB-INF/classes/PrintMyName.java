import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class PrintMyName extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Akash");
    }
}