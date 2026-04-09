package greedy;
import java.io.*;
import java.util.*;
public class B28136 {
	static int cut = 0;
	static int[] arr;
	static void func() {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] >= arr[i]) cut++;
		}
		if (arr[arr.length - 1] >= arr[0]) cut++;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		func();
		System.out.println(cut);
	}
}
