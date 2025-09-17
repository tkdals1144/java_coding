package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 정점의 개수 N
		int N = Integer.parseInt(st.nextToken());
				
		// 간선의 개수 M
		int M = Integer.parseInt(st.nextToken());
		
		// 간선이 연결하는 두 정점의 번호
		int[][] ar = new int[M][2];
		
		// 탐색을 시작할 정점의 번호 V
		int V = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			
		}
	}
}
