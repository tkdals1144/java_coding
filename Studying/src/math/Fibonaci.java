package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonaci {
	
	static int Fibo(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else return Fibo(n-1) + Fibo(n-2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		System.out.println(Fibo(n));
	}
}
