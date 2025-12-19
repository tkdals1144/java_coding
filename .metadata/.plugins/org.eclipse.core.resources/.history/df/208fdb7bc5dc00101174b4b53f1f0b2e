package dp;
import java.io.*;
import java.util.*;
public class B12015 {
	static int N;
	static int[] arr;
	static int[] lis;
	// lis의 가장 큰 특징은 index i 번째에 들어갈 수 있는 가장 작은 수를 고르는것에 있다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		int size = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			if (i == 0) lis[i] = arr[i];
			else {
				if (lis[size-1] < arr[i]) {
					lis[size++] = arr[i];
				} else {
					// lis 배열에서 0 ~ size 까지 arr[i]라는 값이 있는가 확인
					int num = Arrays.binarySearch(lis, 0, size, arr[i]);
					if (num >= 0) continue;
					// 없는값이라면 옳은 위치에 삽입해야 함
					else {
						int temp = -(num + 1);
						lis[temp] = arr[i];
					}
				}
			}
		}
		System.out.println(size);
	}
}
