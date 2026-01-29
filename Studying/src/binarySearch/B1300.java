package binarySearch;
import java.util.*;
import java.io.*;
public class B1300 {
	static int[] B;
	static int N;
	static void reset() {
		int idx = 0;
		// 음.. 정렬하는순간 터질각인데
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				B[idx++] = (i+1) * (j+1);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		B = new int[(int)Math.pow(N,2)];
		reset();
	}
}
