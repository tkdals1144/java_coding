package greedy;
import java.io.*;
import java.util.*;
public class B30020 {
	static int A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		ArrayList<Integer> p = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();
		if (A > (B * 2) || A <= B) {
			System.out.println("NO");
			return;
		}
		while (true) {
			if (A == (B + 1)) {
				p.add(A);
				c.add(B);
				break;
			} else {
				p.add(2);
				c.add(1);
				A -= 2;
				B--;
			}
		}
		System.out.println("YES");
		System.out.println(p.size());
		for (int i = 0; i < p.size(); i++) {
			for (int j = 0; j < p.get(i); j++) {
				if (j == p.get(i) - 1) {
					sb.append('a').append('\n');
				} else {
					sb.append("ab");
				}
			}
		}
		System.out.println(sb.toString());
	}
}