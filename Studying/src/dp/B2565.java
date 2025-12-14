package dp;
import java.io.*;
import java.util.*;

public class B2565 {
	static class Wire {
		int a, b;
		Wire(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Wire[] wires = new Wire[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			wires[i] = new Wire(a, b);
		}
		
		// A전봇대 기준 오름차순 정렬
		Arrays.sort(wires, (o1, o2) -> o1.a - o2.a);
		
		// LIS 배열
		// lis[k] = 길이가 (k+1)인 증가 부분 수열의 "마직막 최소값"
		int[] lis = new int[N];
		int size = 0;
		
		// A 기준으로 오름차순된 전선에서 B 값을 통해 LIS 계산
		for (int i = 0; i < N; i++) {
			int cur = wires[i].b;
			
			// 들어갈 위치
			int pos = Arrays.binarySearch(lis, 0, size, cur);
			
			// 값을 찾지 못했다면 삽입할 실제 위치로 변환
			if (pos < 0) {
				pos = -(pos + 1);
			}
			
			lis[pos] = cur;
			if (pos == size) size++;
		}
		System.out.println(N - size);
	}
}
