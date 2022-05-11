import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Working");
        String allRecords = "";
        try {
            resp.setContentType("application/json");

            resp.addHeader("Institute","IJSE");
            resp.addHeader("Course","GDSE");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wholesales", "root", "1234");
            ResultSet rst = connection.prepareStatement("SELECT * FROM Customer").executeQuery();
            while (rst.next()){
                String id = rst.getString(1);
                String address = rst.getString(3);
                String name = rst.getString(4);
                String pc = rst.getString(5);

                System.out.println(id+" "+name+" "+address+" "+pc);

                String customer = "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"address\":\"" + address + "\",\"pc\":" + pc + "},";
                allRecords = allRecords + customer;
            }

            String finalJson = "[" + allRecords.substring(0,allRecords.length()-1) + "]";

            PrintWriter writer = resp.getWriter();
            writer.write(finalJson);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusId = req.getParameter("customerID");
        String cusName = req.getParameter("customerName");
        String address = req.getParameter("custAddress");
        String pc = req.getParameter("custSalary");

        System.out.println(cusId+" "+cusName+" "+address+" "+pc);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wholesales", "root", "1234");
            PreparedStatement pst = connection.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?,?,?)");
            pst.setString(1,cusId);
            pst.setString(4,cusName);
            pst.setString(2,address);
            pst.setString(3,address);
            pst.setString(5,pc);
            pst.setString(6,"South");
            pst.setString(7,"Mr.");

            if (pst.executeUpdate()>0){
                PrintWriter writer = resp.getWriter();
                writer.write("Customer Added Successfully");
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
}
