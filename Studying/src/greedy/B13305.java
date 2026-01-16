package greedy;

import java.io.*;
import java.util.*;

public class B13305 {
	static int N;
	static long[] oil;
	static long[] road;
	static long count = 0;
	static long minOil = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		road = new long[N-1];
		oil = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(st.nextToken());
			minOil = Math.min(minOil, temp);
			oil[i] = minOil;
		}
		for (int i = 0; i < N - 1; i++) {
			count += oil[i] * road[i];
		}
		System.out.println(count);
	}
}
