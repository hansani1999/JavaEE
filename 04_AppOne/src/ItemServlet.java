import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Item Servlet Working");
        String allRecords = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wholesales", "root", "1234");
            ResultSet rst = connection.prepareStatement("SELECT * FROM Item").executeQuery();
            while (rst.next()){
                String code = rst.getString(1);
                String description = rst.getString(2);
                String packSize = rst.getString(3);
                int qty = rst.getInt(4);
                double price = rst.getDouble(5);

                System.out.println(code+" "+description+" "+packSize+" "+qty+" "+price);

                String item = "{\"code\":\"" + code + "\",\"description\":\"" + description + "\",\"packSize\":\"" + packSize + "\",\"qty\":" + qty+",\"price\":" + price + "},";
                allRecords +=item;
            }

            String finalJson = "[" + allRecords.substring(0,allRecords.length()-1) + "]";

            PrintWriter writer = resp.getWriter();
            writer.write(finalJson);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
