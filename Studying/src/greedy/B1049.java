package greedy;
import java.io.*;
import java.util.*;
public class B1049 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int set = Integer.MAX_VALUE;
		int each = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			set = Math.min(set, Integer.parseInt(st.nextToken()));
			each = Math.min(each, Integer.parseInt(st.nextToken()));
		}
		if (each * 6 <= set) {
			System.out.println(each * N);
		} else {
			int a = N / 6;
			int b = N % 6;
			if (set <= b * each) {
				System.out.println((a + 1) * set);
			} else {
				System.out.println(a * set + b * each);
			}
		}
	}
}
