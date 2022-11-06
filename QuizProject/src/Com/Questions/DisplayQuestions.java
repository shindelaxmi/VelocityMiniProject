package Com.Questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Scanner;
 

import Com.DataBase.code.PairConnection;
import Com.Stundent.ClassIdentification;
import Com.Stundent.StoreStudentData;

public class DisplayQuestions {

	LinkedHashMap<Integer, String> queans = new LinkedHashMap<>();// question with answer
	LinkedHashMap<String, Integer> queNo = new LinkedHashMap<>();// que and no
	LinkedHashMap<Integer, ArrayList<String>> queoption = new LinkedHashMap<Integer, ArrayList<String>>();// qno with
																											// option
	ArrayList<String> que = new ArrayList<>();// to show random questions
	Scanner sc = new Scanner(System.in);
	PreparedStatement stmt;
	Connection con;
	ResultSet rs;

	public void DisplayQue(int id, String name)// method to display display question
	{
		try {
			 con = PairConnection.getConnection();
			String str = "select questions.que_no,question,Answer,option1,option2,option3,option4 from questions,options where questions.que_no=options.que_no";
			 stmt = con.prepareStatement(str);
			 rs = stmt.executeQuery();
			int srno = 0;
			int score = 0;
			String optionsDisplay = "";

			while (rs.next()) {
				// data from questions and option table
				int qno = rs.getInt(1);
				String question = rs.getString(2);
				String answer = rs.getString(3);
				String option1 = rs.getString(4);
				String option2 = rs.getString(5);
				String option3 = rs.getString(6);
				String option4 = rs.getString(7);
				// Stored options in arrayList
				ArrayList<String> a = new ArrayList<String>();
				a.add(option1);
				a.add(option2);
				a.add(option3);
				a.add(option4);

				queNo.put(question, qno);// stored question and question no in LinkedHashMap
				queans.put(qno, answer);// Store question no and answer in LinkedHashMap
				que.add(question);// Stored question in arraylist to random the question
				queoption.put(qno, a);// stored qno and options in one linkedHaspmap
			} // end of retrival from db

			ListIterator<String> listiterator = que.listIterator();// to iterate arraylist
			Collections.shuffle(que);// to shuffle arraylist

			// main logic iterate arraylist to show question to user
			System.out.println("Quiz Started...................");
			while (listiterator.hasNext()) {
				srno++; // to show question no
				String ques = (String) listiterator.next();
				System.out.println(srno + " . " + ques);// To display the question

				int qno = queNo.get(ques);
				String ans = queans.get(qno);
				ArrayList<String> optionArrayList = queoption.get(qno);

				// to dispaly the options
				// eg.1) aaaaa
				// 2) bbbb
				// 3) cccc
				// 4) dddd
				ListIterator<String> optionIterator = optionArrayList.listIterator();
				int optionno = 1;
				optionsDisplay = "";
				while (optionIterator.hasNext()) {

					optionsDisplay = optionsDisplay + " " + optionno + ") " + optionIterator.next() + "." + "\n";
					optionno++;
				}
				System.out.println(optionsDisplay);

				// collect answer from user
				System.out.print("Enter Your Answer--");
				int answerOptionusr = sc.nextInt();
				System.out.println();
				String answerUser = optionArrayList.get(answerOptionusr - 1);
				System.out.println("Your Answer is-" + answerUser);
				System.out.println(
						"-----------------------------------------------------------------------------------------------");
				if (ans.equals(answerUser))
					score++;
			}
			System.out.println(name + " Your Score out of 10 is : " + score);
			String Class = ClassIdentification.getClass(score);//class identification to identify class of result
			System.out.println("Your Class is : " + Class);
			if(Class.equals("D"))
			{
				System.out.println("Sorry you are Fail Please Try again......");
			}
			StoreStudentData.storedStudent(id, name, score, Class);//Store student data into a db

			
		} catch (SQLException e) {

		}
		finally {
			try {
			con.close();
			stmt.close();
			rs.close();
			}
			catch(SQLException e) {}
		}

	}

	public static void main(String[] args) {

	}

}
