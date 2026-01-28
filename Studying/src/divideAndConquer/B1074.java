package divideAndConquer;

import java.io.*;
import java.util.*;

public class B1074 {
	static int r, c;
	static int count = 0;
	static int answer = 0;
	static void divide(int x, int y, int size) {
		if (size == 1) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (r == y+i && c == x+j) answer = count;
					count++;
				}
			}
			return;
		}
		// 1 -> 4
		// 2 -> 16
		// 3 -> 64
		int plus = (int)Math.pow(4, size);
		int half = size - 1;
		int value = (int)Math.pow(2, half);
		if (c < x+value && r < y+value) {
			divide(x, y, half);
		} else if (x+value <= c && r < y+value) {
			count += (plus / 4);
			divide(x+value, y, half);
		} else if (c < x+value && y+value <= r) {
			count += (plus / 4) * 2;
			divide(x, y+value, half);
		} else {
			count += (plus / 4) * 3;
			divide(x+value, y+value, half);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		divide(0, 0, N);
		System.out.println(answer);
	}
}
