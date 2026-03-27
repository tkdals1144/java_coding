package greedy;
import java.io.*;
import java.util.*;
public class B16471 {
	static int N;
	static Integer[] me;
	static Integer[] you;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		me = new Integer[N];
		you = new Integer[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			me[i] = Integer.parseInt(st1.nextToken());
			you[i] = Integer.parseInt(st2.nextToken());
		}
		// 나는 오름차순
		Arrays.sort(me, (a, b) -> a - b);
		// 쟤는 내림차순
		Arrays.sort(you, (a, b) -> b - a);
		boolean check = true;
		for (int i = 0; i < N/2 + 1; i++) {
			if (me[N/2 - i] >= you[i]) {
				check = false;
				break;
			}
		}
		// 3 2 1 5 6
		// 5 3 2 1 1
		if (check) System.out.println("YES");
		else System.out.println("NO");
	}
}
