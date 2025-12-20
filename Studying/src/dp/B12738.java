package dp;
import java.util.*;
import java.io.*;
public class B12738 {
	static int N;
	static int[] arr;
	static int[] lis;
	static int size = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				// 가장 첫번째 입력값 주입
				lis[size++] = arr[i];
			} else {
				// 가장 끝에 값을 주입하는 경우
				if (lis[size-1] < arr[i]) {
					lis[size++] = arr[i];
				} else {
					// 그게 아니라면 위치를 찾아야 한다
					int num = Arrays.binarySearch(lis, 0, size, arr[i]);
					if (0 <= num) continue;
					int idx = -(num + 1);
					lis[idx] = arr[i];
				}
			}
		}
		System.out.println(size);
	}
}
