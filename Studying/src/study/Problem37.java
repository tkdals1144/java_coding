package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem37 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String NK = bf.readLine();
		StringTokenizer st = new StringTokenizer(NK);
		
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> arr = new Stack<>();
		int k = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		for (int i = 0 ; i < n; i++) {
			int value = Integer.parseInt(bf.readLine());
			arr.push(value);
		}
		
		while (k > 0) {
			while(!arr.isEmpty()) {
				if (k >= arr.peek()) {
					int value = arr.pop();
					int kcount = k / value;
					k -= (kcount * value);
					count += kcount;
					break;
				} else {
					arr.pop();
				}
			}
		}
		System.out.println(count);
	}
}