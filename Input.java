package Elevator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
	protected  static ArrayList<ElevatorReg>	RqstList=new ArrayList<ElevatorReg>();
	ArrayList<String> getInput(){
		Scanner input;
		input = new Scanner(System.in);
		String str;
		ArrayList<String> list=new ArrayList<String>();
		while(input.hasNextLine()){
			str=input.nextLine();
			if(Pattern.matches("(run|RUN)", str))
				break;
			list.add(str);
		}
		input.close();
		return list;
}
	ArrayList<ElevatorReg> getRqstList(){
		return RqstList;
	}
}