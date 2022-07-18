import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;

public class RandomNumbers extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.println("<html><body>");
        pw.println("<div>");
        Random r = new Random();
        for (int i = 6; i >= 1; i--) {
            int x = r.nextInt(100);
            pw.println("<h" + i + "  style='display:inline-block'>" + x + "</h" + i + ">");

        }
        pw.println("</div>");
        pw.println("</body><html>");

    }
}