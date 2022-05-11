package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    public MyFilter(){
        System.out.println("Object created from MyFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("first");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.addHeader("My-Company", "IJSE");
        filterChain.doFilter(req,res);//proceed request to the servlet
        System.out.println("second");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destroyed");
    }
}
