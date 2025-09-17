package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HomeProblem11 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<BigInteger> arr = new ArrayList<>(30);
		arr.add(BigInteger.ONE);
		
		for (int i = 1; i <= 30; i++) {
			arr.add(arr.get(i - 1).multiply(new BigInteger(String.valueOf(i))));
		}
		
		int N = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			BigInteger result = (arr.get(b)).divide(arr.get(b - a).multiply(arr.get(a)));
			sb.append(result).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
