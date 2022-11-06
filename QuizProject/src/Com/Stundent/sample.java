package Com.Stundent;

import java.util.Formatter;

public class sample {
	public static void main(String[] args) {
		Formatter fmt=new Formatter();
		fmt.format("%15s%15s%15s%15s\n","ID","NAME","SCORE","CLASS");
		for(int i=0;i<10;i++)
		{
			fmt.format("%15s%15s%15s%15s\n",i,i*2,(i*3),(i*4));
		}
		System.out.println(fmt);
	}

}
