import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DetailsInTable extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<td>Name</td>");
        pw.println("<td>Akash Yadav</td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Contact No.</td>");
        pw.println("<td>9420656024</td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Qualification</td>");
        pw.println("<td>Student</td>");
        pw.println("</tr>");
        pw.println("</table>");
    }
}