package greedy;
import java.io.*;
import java.util.*;
public class B1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		boolean check = true;
		for (int i = 0; i < input.length; i++, idx++) {
			if (input[i] == '.') {
				if (idx == 1) {
					sb.append('.');
					idx = 0;
					continue;
				} else if (idx == 3) {
					sb.append("BB.");
					idx = 0;
					continue;
				} else {
					check = false;
					break;
				}
			}
			if (idx == 4) {
				sb.append("AAAA");
				idx = 0;
				continue;
			}
			if (i == input.length - 1) {
				if (idx == 2) sb.append("BB");
				else if (idx == 4) sb.append("AAAA");
				else check = false;
			}
		}
		if (check) System.out.println(sb.toString());
		else System.out.println(-1);
	}
}
