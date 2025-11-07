package star;
import java.io.*;

public class B2448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int count1 = N - 1;
		int count2 = 1;
		// 가로길이는 현재 2N - 1
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < count1; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < count2; j++) {
				sb.append("*");
			}
			for (int j = 0; j < count1; j++) {
				sb.append(" ");
			}
			count1--;
			count2 += 2;
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
	}
}
