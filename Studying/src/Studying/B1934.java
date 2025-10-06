package Studying;

import java.util.*;
import java.io.*;
public class B1934 {
	public static int gcd(int a, int b) {
		while (b != 0) {
			// 12 8
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int gcd = gcd(num1, num2);
			sb.append(num1 * num2 / gcd).append("\n");
		}
		System.out.println(sb.toString());
	}
}
