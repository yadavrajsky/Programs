import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeNumber extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        for (int i = 2; i < 50; i++) {
            Boolean prime_no = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime_no = false;

                    break;
                }

            }
            if (prime_no)
                pw.println(i);
        }
    }
}