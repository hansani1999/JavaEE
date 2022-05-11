package listeners;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Listener Initialized");
        //This method is executed at the time the application is started
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/company");
        bds.setUsername("root");
        bds.setPassword("1234");
        bds.setMaxTotal(5);//how many connections
        bds.setInitialSize(5);//how many connections we should initialize

        ServletContext servletContext = servletContextEvent.getServletContext();// a common place for all servlet
        servletContext.setAttribute("bds",bds); // store the pool inside the Servlet Context
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context Listener Destroyed");
    }
}
