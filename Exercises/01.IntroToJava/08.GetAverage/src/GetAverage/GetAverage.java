package GetAverage;

import java.util.Scanner;
public class GetAverage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		float firstNumber = in.nextFloat();
		float secondNumber = in.nextFloat();
		float thirdNumber= in.nextFloat();
		
		System.out.printf("%.2f", getAverage(firstNumber, secondNumber, thirdNumber));
	}
	
	public static float getAverage(float firstNumber, float secondNumber, float thirdNumber)
	{
		return (firstNumber + secondNumber + thirdNumber) / 3;
	}
}
