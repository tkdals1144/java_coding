package divideAndConquer;
import java.util.*;
import java.io.*;

public class B1629 {
	// (A^B) % C -> (A^(B/2) % C)^2
	static long A, B, C;
	static long divide(long a, long b) {
		if (b == 1) {
			return a % C;
		}
		
		long half = divide(a, b / 2);
		long result = (half * half) % C;
		
		if (b % 2 == 1) {
			result = (result * a) % C;
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		System.out.println(divide(A, B));
	}
}
