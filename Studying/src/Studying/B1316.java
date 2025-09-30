package Studying;

import java.io.*;
import java.util.*;

public class B1316 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char check = 0;
		int N = Integer.parseInt(br.readLine());
		int answer = N;
		
		for (int i = 0; i < N; i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			char[] chArr = br.readLine().toCharArray();
			for (char ch : chArr) {
				if (map.containsKey(ch)) {
					if (check == ch) continue;
					else {
						answer--;
						break;
					}
				} else {
					map.put(ch, 1);
					check = ch;
				}
			}
		}
		System.out.println(answer);
	}
}
