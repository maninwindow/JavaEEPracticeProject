

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterChecks
 */
@WebServlet("/RegisterChecker")
public class RegisterChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("user");
        String p = request.getParameter("pass");
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","Pinhan@315");
            
            PreparedStatement ps = con.prepareStatement("insert into LoginChart(username,password,name) values(?,?,?)");
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, n);
            
            int i = ps.executeUpdate();
            if(i>0)
            {
                response.sendRedirect("index.jsp");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(RegisterChecker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    out.close();
	}

}
