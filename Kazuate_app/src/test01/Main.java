package test00;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int i = guessNumber(0);
		System.out.println(i);
		
	}
	
	public static int guessNumber(int number) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
	}
}
