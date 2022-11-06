package Com.Stundent;

public class ClassIdentification {
	
	static String Class="";
	public static String getClass(int Score)
	{
		
		if(Score>8 && Score<=10)
		{
			Class="A";
			
		}
		else if(Score>=6 && Score<=8)
		{
			Class="B";
			
		}
		else if(Score==5)
		{
			Class="C";
			
		}
		else
		{
			Class="D";
			
		}
		return Class;
			
		
	}

}
