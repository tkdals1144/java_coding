package study;

import java.util.Scanner;

public class HomeProblem10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long num = 1;
		if (a == 0) System.out.println(num);
		else {
			for (int i = 1; i <= a; i++) {
				num *= i;
			}
			System.out.println(num);
		}
	}
}
