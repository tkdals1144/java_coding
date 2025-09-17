package study;

import java.util.Scanner;

public class HomeProblem09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] ar = new char[8][8];
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			String str= sc.nextLine();
			ar[i] = str.toCharArray();
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				if (i % 2 == 0 && j % 2 == 0 && ar[i][j] == 'F') sum++;
				if (i % 2 == 1 && j % 2 == 1 && ar[i][j] == 'F') sum++;
			}
		}
		System.out.println(sum);
	}
}
