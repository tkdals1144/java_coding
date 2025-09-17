package Studying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Study04 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(bf.readLine());
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < num; i++) {
			set.add(bf.readLine());
		}
		
		ArrayList<String> arr = new ArrayList<>(set);
		
		Collections.sort(arr, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			} else {
				return o1.length() - o2.length();
			}
		});
		
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}