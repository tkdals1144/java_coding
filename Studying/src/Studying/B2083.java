package Studying;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B2083 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.equals("# 0 0")) break;
			StringTokenizer st = new StringTokenizer(input);
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (17 < age || 80 <= weight) {
				sb.append(name+ " Senior").append('\n');
			} else {
				sb.append(name + " Junior").append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}
