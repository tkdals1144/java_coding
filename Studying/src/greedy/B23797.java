package greedy;
import java.io.*;
import java.util.*;
public class B23797 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int countK = 0;
		int countP = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'K') {
				// 만약 P로 끝난 개구리가 존재한다면
				if (countP > 0) {
					countK++;
					countP--;
				} else {
					countK++;
				}
			} else {
				// 만약 K로 끝난 개구리가 존재한다면
				if (countK > 0) {
					countK--;
					countP++;
				} else {
					countP++;
				}
			}
		}
		System.out.println(countK + countP);
	}
}