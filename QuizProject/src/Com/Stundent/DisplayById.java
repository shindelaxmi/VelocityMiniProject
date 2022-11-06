
package Com.Stundent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

import Com.DataBase.code.PairConnection;

public class DisplayById {

	public DisplayById(int id)
	{
		
		try {
			String query="select * from student where id=?";
			PairConnection con=new PairConnection();
			PreparedStatement stmt=con.getStatement(query);
			stmt.setInt(1, id);
		 	ResultSet rs=stmt.executeQuery();
		 	if(rs.next()) {
				Formatter fmt=new Formatter();
				System.out.println("------------------------------------------");
		 		
				fmt.format("%10s%10s%10s%10s\n","ID","NAME","SCORE","CLASS");
				System.out.println(fmt);

				
					System.out.println("------------------------------------------");
			 		System.out.format("%10s%10s%10s%10s\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			
				
				System.out.println("------------------------------------------");
			}
			else
			{
				System.out.println("No Records Available");
			}
			 	
				
			
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
