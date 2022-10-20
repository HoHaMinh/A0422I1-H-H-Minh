import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServelet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float vnd = Float.parseFloat(request.getParameter("vnd"));
        float percent = Float.parseFloat(request.getParameter("percent"));

        float caculator = vnd * (100-percent)/100;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>List Price: " + vnd + "</h1>");
        writer.println("<h1>Discount Percent: " + percent + "%" + "</h1>");
        writer.println("<h1>Price after discount: " + caculator + "</h1>");
        writer.println("</html>");
    }
}
