import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/json")
public class JSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        JsonObjectBuilder objectB = Json.createObjectBuilder();

        objectB.add("id","C00-001");
        objectB.add("name","Ramal");
        objectB.add("address","Galle");
        objectB.add("salary","50000");
        JsonObject build = objectB.build();

        /*PrintWriter writer = resp.getWriter();
        writer.print(build);

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        JsonObjectBuilder objectB = Json.createObjectBuilder();
        objectB.add("id","C00-001");
        objectB.add("name","Ramal");
        objectB.add("address","Galle");
        objectB.add("salary","50000");
        arrayBuilder.add(objectB.build());

        JsonObjectBuilder objectB2 = Json.createObjectBuilder();
        objectB2.add("id","C00-002");
        objectB2.add("name","Dasun");
        objectB2.add("address","Panadura");
        objectB2.add("salary","80000");
        arrayBuilder.add(objectB2.build());*/

        //writer.write();
        //writer.print(arrayBuilder.build());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());
        /*JsonArray array = reader.readArray();

        for (int i=0; i<array.size(); i++){
            JsonObject jsonObject = array.get(i).asJsonObject();
            System.out.println(jsonObject.getString("id")+"-"+jsonObject.getString("name")+"-"+jsonObject.getString("address")+"-"+jsonObject.getString("salary"));
        }*/
        /*String id = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        String address = jsonObject.getString("address");*/

        //System.out.println(id+" "+name+" "+address);
        /*System.out.println("PUT method called");

        ServletInputStream inputStream = req.getInputStream();

        int read;

        while ((read=inputStream.read())!=-1){
            System.out.print((char)read);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());
        /*JsonArray array = reader.readArray();

        for (int i=0; i<array.size(); i++){
            JsonObject jsonObject = array.get(i).asJsonObject();
            System.out.println(jsonObject.getString("id")+"-"+jsonObject.getString("name")+"-"+jsonObject.getString("address")+"-"+jsonObject.getString("salary"));
        }*/
        JsonArray jsonArray = reader.readArray();
        for (JsonValue jsonValue : jsonArray) {

            String customerID = jsonValue.asJsonObject().getString("id");
            String customerName = jsonValue.asJsonObject().getString("name");
            String customerAddress = jsonValue.asJsonObject().getString("address");
            String customerSalary = jsonValue.asJsonObject().getString("salary");
            System.out.println(customerID + " " + customerName + " " + customerAddress + " " + customerSalary);
        }
    }
}
