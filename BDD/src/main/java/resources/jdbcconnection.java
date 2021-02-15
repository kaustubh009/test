package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" +port+ "/QADBt" , "root", "ONS@jsr21");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo");
		
		
		while(rs.next())
		{
		System.out.println(rs.getString("Name"));
		System.out.println(rs.getString("EID"));
		System.out.println(rs.getString("Age"));
		System.out.println(rs.getString("Location"));
		
		rs.next();
		
		}
		
		
	}

}
