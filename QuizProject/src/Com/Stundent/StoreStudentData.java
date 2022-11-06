package Com.Stundent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Com.DataBase.code.PairConnection;

public class StoreStudentData {

	public static void storedStudent(int id,String name,int Score,String Class)
	{
		Connection con=null;
		PreparedStatement stmt=null;
		try {
		 	
			 con=PairConnection.getConnection();
			stmt=con.prepareStatement("insert into student (id,name,score,class) values(?,?,?,?)");
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.setInt(3, Score);
			stmt.setString(4, Class);
			stmt.executeUpdate();
			con.close();
			stmt.close();
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		 
	}
}
