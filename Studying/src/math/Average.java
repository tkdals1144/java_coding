package math;

import java.util.*;
import java.io.*;

public class Average {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(bf.readLine());
		int score;
		double count;
		double sum;
		
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(bf.readLine());
			double N = Double.parseDouble(st.nextToken());
			double[] students = new double[(int)N];
			sum = 0;
			count = 0;
			for (int j = 0; j < N; j++) {
				score = Integer.parseInt(st.nextToken());
				students[j] = score;
				sum += score;
			}
			for (int j = 0; j < N; j++) {
				if (students[j] > (int)(sum / N)) count++;
			}
			count *= 100;
			sb.append(String.format("%.3f", (double)((count) / N))).append("%\n");
		}
		
		System.out.println(sb.toString());
	}
}
