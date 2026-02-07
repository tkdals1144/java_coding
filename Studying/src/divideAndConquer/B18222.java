package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18222 {
	// 큰 문제를 작게 쪼갠다.
	// 계속해서 반절로 나누는게 가능하다.
	// 0110 / 1001 / 1001 / 0110
	// 처음부터 전체 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		int cnt = Long.bitCount(k - 1);
		System.out.println(cnt % 2);
	}
}
