import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestDeploymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method =  req.getMethod();
        System.out.println(method);
        PrintWriter writer = resp.getWriter();
        writer.write("<h1 style = \"color:red\">Request Received and Response Generated</h1>");

    }
}
