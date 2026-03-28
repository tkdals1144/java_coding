package greedy;
import java.io.*;
import java.util.*;
public class B28014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] spire = new int[N];
		int count = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			spire[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			if (spire[i] >= spire[i-1]) count++;
		}
		System.out.println(count);
	}
}
