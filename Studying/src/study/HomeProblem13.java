package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeProblem13 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[10];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		
		for (int i = 3; i < 10; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		int N = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(bf.readLine());
			sb.append(arr[n-1] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
