package divideAndConquer;
import java.util.*;
import java.io.*;
public class B18291 {
	// 문제는 모든 경우의 수를 요구하고 있다.
	// 1번 -> N 번까지 가는 모든 경우의 수
	// 뛰는 개수는 몇이든 상관없다 (즉, 단순하게 접근한다면 시간초과가 날 확률이 높다)
	// 일단 앞으로만 이동 가능하다.
	// dp로 해결하기에는 이전 상태에 추가 상태를 더하는것으로 해결이 불가능해 보인다
	
	// 1 -> 2
	// 1 -> 2 -> 3, 1 -> 3
	// 1 -> 4, 1 -> 2 -> 4, 1 -> 3 -> 4, 1 -> 2 -> 3 -> 4
	// 1 -> 5, 1 -> 2 -> 5, 1 -> 3 -> 5, 1 -> 4 -> 5 ...
	// 아. 이거 조합이다
	// 1 과 N 사이에서 (0 ~ N-2) 개를 고르는 경우의 수
	// (N-2) C 0 + (N-2) C 1 + (N-2) C 2 + (N-2) C 3 + ... + (N-2) C N-2;
	// 이거 ... 2^(N-2) 이잖아...?
	static final int MOD = 1000000007;
	static int N;
	static long divide(int size) {
		if (size == 1) return 2;
		long half = divide(size / 2);
		long result = (half * half) % MOD;
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			long result = divide(N-2);
			sb.append(result).append('\n');
		}
		System.out.println(sb.toString());
	}
}
