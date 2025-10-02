package Studying;

import java.io.*;
import java.util.*;

public class B10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			if (map.containsKey(arr[i])) sb.append("1 ");
			else sb.append("0 ");
		}
		
		System.out.println(sb.toString());
	}
}
