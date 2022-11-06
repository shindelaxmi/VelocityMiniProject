package Com.menu;

import java.util.Scanner;

public class MainMenu {
	Scanner sc = new Scanner(System.in);

	public int getChoice()
	{
		
		System.out.println("----------------------Wellcome To Quiz Compitition ----------------------");
		int  choice;
		System.out.println("1. Attend the quiz.");
		System.out.println("2. Display all students score. ");
		System.out.println("3. Retrive Student Data by Student Id.");
		System.out.println("4. Exit");
		
		System.out.print("Enter Your Choice : ");

		choice = sc.nextInt();
		
		return choice;
		
	}
	 
}
