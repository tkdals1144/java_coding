package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13171 {
	static long X;
	static final long MOD = 1000000007;
	static long pow(long num, long size) {
		if (size == 1) {
			return num;
		}
		
		long half = pow(num, size / 2);
		long result = ((half % MOD) * (half % MOD)) % MOD;
		
		if (size % 2 == 1) {
			result = (result * num) % MOD;
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A = Long.parseLong(br.readLine());
		X = Long.parseLong(br.readLine());
		A = A % MOD;
		long output = pow(A, X);
		System.out.println(output);
	}
}
