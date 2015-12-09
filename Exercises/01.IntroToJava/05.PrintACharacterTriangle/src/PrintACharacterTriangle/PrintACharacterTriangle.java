package PrintACharacterTriangle;

import java.util.Scanner;

public class PrintACharacterTriangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i ++)
		{
			for(int j = 0; j <= i; j++)
			{
				System.out.print((char)(j + 97) + " ");
			}
			
			System.out.println();
		}
		
		for(int i = n - 1; i >= 0; i --)
		{
			int digitCount = 0;
			for(int j = i - 1; j >= 0; j--)
			{
				System.out.print((char)(digitCount + 97) + " ");
				digitCount++;
			}
			
			System.out.println();
		}
	}

}
