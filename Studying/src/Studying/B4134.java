package Studying;
import java.util.*;
import java.io.*;

public class B4134 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		boolean[] numArr = new boolean[100000];
		Arrays.fill(numArr, true);
		numArr[0] = false;
		numArr[1] = false;
		
		for (long i = 2; i*i < numArr.length; i++) {
			if (numArr[(int)i]) {
				for (long j = i*i; j < numArr.length; j+=i) {
					numArr[(int)j] = false;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			if (num < 100000) {
				while (!numArr[(int)num]) {
					num++;
				}
			} else {
				for (long j = 2; j * j <= num; j++) {
					if (numArr[(int)j] && num % j == 0) {
						num++;
						j = 1;
					}
				}
			}
			sb.append(num).append('\n');			
		}
		System.out.println(sb.toString());
	}
}
