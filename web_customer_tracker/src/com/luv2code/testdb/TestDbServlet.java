package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user="root";
		String password="12345";
		String url="jdbc:mysql://localhost:3306/web_customer_tracker";
		String driver="com.mysql.jdbc.Driver";
		
		Connection connection =null;
		
 
		
          try {
			
      		PrintWriter out=response.getWriter();
			//out.println("Connection databese"+url);
			Class.forName(driver);
		    out.println("Baglaniliyor"+url);
			connection=DriverManager.getConnection(url,user,password);
			out.println("Seccesful");
			connection.close();
		
		} catch (Exception e) {
		

			e.printStackTrace();
			throw new ServletException()
			;
		
		}
		
		
		
		}
	
	
	
	}

