package servletProgram;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/LoginOperation")
public class LoginOperation extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
//protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
	//fetch data
	String email=req.getParameter("mail");
	String password=req.getParameter("pwd");
	//jdbc code
	String url="jdbc:mysql://sql12.freesqldatabase.com:3306?user=sql12605095&password=8Zl8qwj9Fw";
	String query="insert into sql12605095.Employee values('rajitha','reddy',24)";
	//load mysql driver
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =DriverManager.getConnection(url);
        PreparedStatement ps= connection.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        PrintWriter writer=resp.getWriter();
        if (rs.next())
        {
        	String firstName=rs.getString("firstname");
        	String lastName=rs.getString("lastname");
        	writer.println("<h1 style='color:green;'>Welcome..!"+firstName+" "+lastName+"</h1>");
		}
        else
        {
        	writer.println("<h1 style='color:red;'> Invalid Data...!</h1>");
        }
        connection.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
