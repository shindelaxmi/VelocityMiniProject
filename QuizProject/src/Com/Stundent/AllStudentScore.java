package Com.Stundent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;

import Com.DataBase.code.PairConnection;

public class AllStudentScore {
	
	Connection con=null;
	PreparedStatement stmt= null;
	
	
	public void displayStudentScore() {
		
		try {
		con= PairConnection.getConnection();
		stmt=con.prepareStatement("select * from student order by score desc ");
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			
			Formatter fmt=new Formatter();
			System.out.println("------------------------------------------");
	 		
			fmt.format("%10s%10s%10s%10s\n","ID","NAME","SCORE","CLASS");
			System.out.println(fmt);
			rs.beforeFirst();
		 	while(rs.next())
			{
		 		
		 		System.out.println("------------------------------------------");
		 		System.out.format("%10s%10s%10s%10s\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			
			}
		 	System.out.println("------------------------------------------");
	 		
		 	
		}
		else
		{
			System.out.println("No records Found");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
