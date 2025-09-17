package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HomeProblem07 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] ar = bf.readLine().split(" ");
		int M = Integer.valueOf(ar[0]);
		int N = Integer.valueOf(ar[1]);
		boolean[] arr = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			arr[i] = true;
		}
		arr[1] = false;
		arr[0] = false;
		
		// 에라토스테네스의 체 -> 2, 3, 5, 7, 11 등 각 소수들로 이루어진 배수의 값들을 제거하는 방식으로 계산
		// i * i 로 진행하는 이유는 제곱수로 해야 이전에 이미 계산한 값들을 또다시 검사하지 않기 때문이다.
		for (int i = 2; i * i <= N; i++) {
			// 만약 해당값이 현재 true(소수)로 잡혀있다면
			if (arr[i]) {
				// 소수의 배수들은 결국 전부 false(소수가 아닌 수)가 된다.
				for (int j = i * i; j <= N; j += i) {
					arr[j] = false;
				}
			}
		}
		for (int i = M; i <= N; i++) {
			if (arr[i]) {
				sb.append(i + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		bf.close();
	}
}
