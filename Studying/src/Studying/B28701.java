package Studying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B28701 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int value1 = 0;
		int value2 = 0;
		int value3 = 0;
		for (int i = 1; i <= N; i++) {
			value1 += i;
			value3 += (i * i * i);
		}
		value2 = value1 * value1;
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
	}
}
