package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15717 {
	// (0)
	// 1 0
	
	// (1)
	// 2 0 0 -> 1
	// 1 1 0 -> 1
	
	// (2) = (0) + (1) + (0 + 1)
	// 3 0 0 0 -> 1
	// 2 1 0 0 -> 1
	// 1 2 0 0 
	// 1 1 1 0 -> 2
	
	// (3) = (0) + (1) + (0 + 1) + (2)
	// (3) = (2) + (2)
	// 4 0 0 0 0 -> 1
	// 3 1 0 0 0 -> 1
	// 2 2 0 0 0
	// 2 1 1 0 0 -> 2
	// 1 3 0 0 0
	// 1 2 1 0 0
	// 1 1 2 0 0
	// 1 1 1 1 0 -> 4
	
	// 음...
	// 가장 앞 숫자에 따라 뒷 개수가 결정되는 느낌인가?
	// 아! 이거 바로 앞의 것들을 전부 더하는식으로 나오게 되네.
	// 결국 바로 이전것의 2배수가 되는것같다?
	// 결국 2^(N-1)을 구하는 문제 같다.
	
	static long N;
	static final int MOD = 1000000007;
	static long pow(long size) {
		if (size == 0) {
			return 1;
		}
		if (size == 1) {
			return 2;
		}
		
		long half = pow(size / 2);
		long result = ((half % MOD) * (half % MOD)) % MOD;
		
		if (size % 2 == 1) {
			result = (result * 2) % MOD;
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		System.out.println(pow(N-1));
	}
}
