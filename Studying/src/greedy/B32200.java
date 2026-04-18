package greedy;
import java.io.*;
import java.util.*;
public class B32200 {
	static int N, X, Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int t = Y - X;
		int count = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			while (arr[i] >= X) {
				temp++;
				arr[i] -= X;
			}
			arr[i] -= (temp * t);
			if (arr[i] < 0) arr[i] = 0;
			count += temp;
			sum += arr[i];
		}
		System.out.println(count);
		System.out.println(sum);
	}
}
