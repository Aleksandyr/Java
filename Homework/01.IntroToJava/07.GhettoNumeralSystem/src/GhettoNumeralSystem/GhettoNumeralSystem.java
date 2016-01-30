package GhettoNumeralSystem;

import java.util.Scanner;;
public class GhettoNumeralSystem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		String[] ghetoNumeralSystem = {
				"Gee", 
				"Bro", 
				"Zuz", 
				"Ma", 
				"Duh", 
				"Yo", 
				"Dis", 
				"Hood", 
				"Jam", 
				"Mack"};
		
		
		String result = "";
		int reversedNumber = reverseNumber(n);
		while(reversedNumber != 0)
		{
			int index = reversedNumber % 10;
			reversedNumber /= 10;
			result += ghetoNumeralSystem[index];
		}
		
		System.out.print(result);
	}
	
	public static int reverseNumber(int n)
	{
		int result = 0;
		while(n != 0)
		{
			result = result * 10;
			result += n % 10;
			n /= 10;
		}
		
		return result;
	}

}
