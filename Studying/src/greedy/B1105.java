package greedy;
import java.io.*;
import java.util.*;
public class B1105 {
	static char[] L, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = st.nextToken().toCharArray();
		R = st.nextToken().toCharArray();
		if (L.length != R.length) System.out.println(0);
		else {
			int count = 0;
			for (int i = 0; i < L.length; i++) {
				if (L[i] == R[i]) {
					if (L[i] == '8') count++;
				} else {
					break;
				}
			}
			System.out.println(count);
		}
	}
}