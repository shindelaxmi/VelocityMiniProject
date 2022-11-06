package Com.menu;

import java.util.Scanner;

import Com.Questions.DisplayQuestions; 

public class FirstMenu {
	int id;
	String name;
	Scanner sc=new Scanner(System.in);
	
	public  FirstMenu()
	{
		  
		System.out.print("Please enter your id : ");
		id=sc.nextInt();
	 	System.out.print("Enter your Name : ");
		name=sc.next();
		 

		DisplayQuestions dq = new DisplayQuestions();
		dq.DisplayQue(id,name);
	}
}
