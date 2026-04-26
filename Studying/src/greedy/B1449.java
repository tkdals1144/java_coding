package greedy;
import java.io.*;
import java.util.*;
public class B1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int loc = arr[0] + L;
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] < loc) continue;
			else {
				loc = arr[i] + L;
				count++;
			}
		}
		System.out.println(count);
	}
}
