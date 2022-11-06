package Com.DataBase.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class PairConnection {

	 
	public static Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mcq_db?autoReconnect=true&useSSL=false",
					"root", "root");

		//	System.out.println("successful...");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return con;

	}
	public PreparedStatement getStatement(String Query)
	{
		Connection con=getConnection();
		PreparedStatement st=null;
		try {
			st=con.prepareStatement(Query);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}
	
}
