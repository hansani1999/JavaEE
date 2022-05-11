import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/items/*")
public class WildCardMappingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WildCard Mapping Spec Invoked");

        String servletPath = req.getServletPath();
        String method = req.getMethod();
        String pathInfo = req.getPathInfo();
        String contextPath = req.getContextPath();

        System.out.println("=========================");
        System.out.println("ServletPath "+servletPath);
        System.out.println("Method "+method);
        System.out.println("PathInfo "+pathInfo);
        System.out.println("ContextPath "+contextPath);
        System.out.println("=========================");
    }
}
