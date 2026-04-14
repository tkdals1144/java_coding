package greedy;
import java.io.*;
import java.util.*;
public class B4796 {
	// P일 중 최대 L일, V: 휴가 전체 수
	static int L, P, V;
	static int idx = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			if (L == 0 && P == 0 && V == 0) break;
			int count = 0;
			while (V >= P) {
				count += L;
				V -= P;
			}
			if (V >= L) {
				count += L;
			} else {
				count += V;
			}
			sb.append("Case " + idx + ": " + count).append('\n');
			idx++;
		}
		System.out.println(sb.toString());
	}
}
