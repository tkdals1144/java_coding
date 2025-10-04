package Studying;

import java.io.*;
import java.util.*;

public class B1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Set<Integer> setA = new HashSet<Integer>();
		Set<Integer> setB = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		int count = A + B;
				
		for (int i = 0; i < A; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < B; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i : setA) {
			if (setB.contains(i)) count--;
		}
		
		for (int i : setB) {
			if (setA.contains(i)) count--;
		}
		
		System.out.println(count);
	}
}
