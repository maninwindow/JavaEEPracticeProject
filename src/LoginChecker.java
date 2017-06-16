

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class LoginChecker
 */
@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		final String dbUrl = "jdbc:mysql://localhost:3306/sakila";
		final String dbUser = "root";		
		final String dbPass = "Pinhan@315";
		
		//Fetching the parameters from the JSP page
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		//To check if JDBC driver exists
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException exc) {
		    exc.printStackTrace();
		}
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			System.out.println("Database connection successful!\n");
			
			// 2. Creating a statement
			myStmt = myConn.prepareStatement("SELECT * from LoginChart where username=? and password=?");

			// 4. Insert variables in the SQL Statement
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 4. Process the result set & redirect accordingly
			if(myRs.next() == false){
				//Creating a session with the session name as 'User'
				HttpSession session = request.getSession();
				session.setAttribute("SessionName", "");
				//redirecting request
				request.getRequestDispatcher("/Failed.jsp").forward(request, response);
			}
			else{
				//Creating a session with the session name as 'name' of the User from the DB
				HttpSession session = request.getSession();
		  		session.setAttribute("SessionName", myRs.getString("name"));
		  		//redirecting request
		  		request.getRequestDispatcher("/Success.jsp").forward(request, response);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			try {
				close(myConn, myStmt, myRs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
}
