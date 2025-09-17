package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class HomeProblem05 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<>();
		int K = Integer.valueOf(bf.readLine());
		int sum = 0;
		
		for (int i = 0; i < K; i++) {
			int a = Integer.valueOf(bf.readLine());
			if (a == 0) {
				stack.pop();
			} else {
				stack.add(a);
			}
		}
		for (int a : stack) {
			sum += a;
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		bf.close();
	}
}
