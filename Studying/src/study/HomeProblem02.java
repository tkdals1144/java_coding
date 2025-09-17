package study;

import java.util.Scanner;

public class HomeProblem02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int[][] ar = new int[2][testCase];
		
		// ar[0] => x
		// ar[1] => y
		for (int i = 0; i < testCase; i++) {
			ar[0][i] = sc.nextInt();
			ar[1][i] = sc.nextInt();
		}
		
		for (int i = 0; i < testCase; i++) {
			int ranking = 1;
			for (int j = 0; j < testCase; j++) {
				if (i == j) continue;
				
				if (ar[0][i] < ar[0][j] && ar[1][i] < ar[1][j]) {
					ranking++;
				}
			}
			System.out.print(ranking + " ");
		}
		sc.close();
	}
}
