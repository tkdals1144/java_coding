package Studying;

import java.util.Arrays;
import java.util.Scanner;

public class B6840 {
	public static void main(String[] args) {
		int[] ar = new int[3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			ar[i] = sc.nextInt();
		}
		Arrays.sort(ar);
		System.out.println(ar[1]);
	}
}
