package greedy;
import java.io.*;
import java.util.*;
public class B35494 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long V = 0;
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i]);
			V += max;
		}
		if (V % 3 == 0) System.out.println("Delicious!");
		else System.out.println("Oh My God!");
	}
}
