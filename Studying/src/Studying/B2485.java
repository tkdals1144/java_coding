package Studying;
import java.util.*;
import java.io.*;

public class B2485 {
	static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	// 5 8 17
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long min = 0;
		long gcdNum = 0;
		long count = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		long[] arr = new long[(int) N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			if (i == 1) {
				min = arr[i] - arr[i-1];
				map.put(min, 1);
				gcdNum = min;
			} else if (i != 0) {
				long num = arr[i] - arr[i-1];
				if (!map.containsKey(num)) {
					map.put(num, 1);
				} else {
					map.put(num, map.get(num) + 1);
				}
				if (min > num) min = num;
			}
		}
		Set<Long> keySet = map.keySet();
		for (long i : keySet) {
			gcdNum = gcd(gcdNum, i);
		}
		for (long i : keySet) {
			if (gcdNum == 0) break;
			count += (i / gcdNum - 1) * map.get(i);
		}
		System.out.println(count);
	}
}
