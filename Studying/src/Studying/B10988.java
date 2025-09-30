package Studying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = bf.readLine().toCharArray();
		// abcdcba -> 7자리
		// 0123
		// 6543
		int check = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[arr.length-1-i]) {
				check = 0;
				break;
			}
		}
		System.out.println(check);
	}
}
