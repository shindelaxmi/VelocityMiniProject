package Com.AdminModule;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FirstRunClass {

	Connection con = null;

	Statement st, st1 = null;
	Scanner sc=new Scanner(System.in);
	

	public void getConection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			System.out.print("Enter Mysql Username: ");
			String user=sc.next();
			System.out.println("Enter Mysql Password: ");
			String pwd=sc.next();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?autoReconnect=true&useSSL=false", user,
					pwd);
			System.out.println("Connection Established");
			st = con.createStatement();
			String Sql = "CREATE DATABASE MCQ_DB";

			st.executeUpdate(Sql);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MCQ_DB", "root", "root");

			// 1.create questions and options
			st.executeUpdate("use  MCQ_DB");
			Sql = " create table Questions(que_no int not null,question varchar(255),answer varchar(255),primary key(que_no));";
			st.executeUpdate(Sql);

			Sql = "create table Options( Que_No int  not null auto_increment,Option1 varchar (255),Option2 varchar (255), Option3 varchar (255), Option4 varchar (255),primary  key(Que_No),foreign key (Que_No) references Questions(Que_NO) );";
			st.executeUpdate(Sql);

			st1 = con.createStatement();
			st1.addBatch(
					"	insert into questions(que_no,question, answer)values(1,\"Who invented Java Programming ?.\",\"James Gosling\");\r\n"
							+ "");
			st1.addBatch(
					"	insert into Options values(1,\"Guido van Rossum\",\"James Gosling\",\"Dennis Ritchie\",\"Bjarne Stroustrup\");\r\n"
							+ "");

			st1.addBatch(
					" insert into questions(que_no,question, answer)values(2,\"Which component is used to compile, debug and execute the java programs ?.\",\"JDK\");\r\n"
							+ "");

			st1.addBatch("insert into Options values(2,\"JRE\",\"JIT\",\"JDK\",\"JVM\");\r\n" + "");

			st1.addBatch("insert into questions (que_no,question,answer)values(3,\"What is the extension of java code files?.\",\".java\")\r\n"+"");
			  
			st1.addBatch("insert into Options values (3,\".js\", \".txt\",\".class\",\".java\");\r\n"+"");
			
			
			st1.addBatch("insert into questions (que_no,question,answer)values(4,\"Which component is responsible to run java program?.\",\"JRE\")\r\n"+"");
			  
			st1.addBatch("insert into Options values (4,\"JIT\", \"JDK\",\"JVM\",\"JRE\");\r\n"+"");
			
			
			st1.addBatch("insert into questions (que_no,question,answer)values(5,\"Which of these is an incorrect array declaration?.\",\"int arr[] = int [5] new\")\r\n"+"");
			  
			st1.addBatch("insert into Options values (5,\"int arr[] = new int[5] \", \"int [] arr = new int[5]\",\"int arr[] = new int[5]\",\"int arr[] = int [5] new\");\r\n"+"");
			
			
			
		    st1.addBatch("insert into questions (que_no,question,answer)values (6,\"Which of these cannot be used for a variable name in Java?.\",\"keyword\")\r\n"+"");
			
			st1.addBatch("insert into Options values (6,\"identifier & keyword\", \"identifie\",\"keyword\",\"none of the mentioned\");\r\n"+"");
			
			
			 st1.addBatch("insert into questions (que_no,question,answer)values (7,\"Which of these keywords is used to define interfaces in Java?.\",\"interface\")\r\n"+"");
				
			st1.addBatch("insert into Options values (7,\" intf\", \"Intf \",\"interface\",\"Interface\");\r\n"+"");
				
				

		     st1.addBatch("insert into questions (que_no,question,answer)values (8,\"-Which of the following is a superclass of every class in Java?.\",\"Object class\")\r\n"+"");
					
		    st1.addBatch("insert into Options values (8,\"ArrayList\", \"Abstract class \",\"Object class\",\"String\");\r\n"+"");
					

		     st1.addBatch("insert into questions (que_no,question,answer)values (9,\"compareTo() returns.\",\"An int value\")\r\n"+"");
					
		    st1.addBatch("insert into Options values (9,\"True\", \"False \",\"An int value\",\"None\");\r\n"+"");
					

		     st1.addBatch("insert into questions (que_no,question,answer)values (10,\"When is the finaluze() method calles?.\",\"Object class\")\r\n"+"");
					
		    st1.addBatch("insert into Options values (10,\"Before garbage collection\", \"Before an object goes out of scope \",\"Before a variable goes out of scope\",\"None\");\r\n"+"");
					
		

			
			
			st1.executeBatch();
			Sql = " create table Student(id int ,name varchar(255),score int,class varchar(255));";
			st.executeUpdate(Sql);
			System.out.println("Database Created Successfully run studentInput.java file");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}  

		finally {
			try {
				st1.close();
				st.close();
				con.close();
				sc.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		FirstRunClass Pair = new FirstRunClass();
		Pair.getConection();
	}

}
