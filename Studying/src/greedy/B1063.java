package greedy;
import java.io.*;
import java.util.*;
public class B1063 {
	static Map<Character, Integer> map = Map.of(
			'A', 1,
			'B', 2,
			'C', 3,
			'D', 4,
			'E', 5,
			'F', 6,
			'G', 7,
			'H', 8
			);
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	// stone = 2, king = 1
	static int[][] graph = new int[9][9];
	static boolean check(int x, int y) {
		return x >= 1 && y >= 1 && x <= 8 && y <= 8;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		graph[king.charAt(1) - '0'][map.get(king.charAt(0))] = 1;
		String stone = st.nextToken();
		graph[stone.charAt(1) - '0'][map.get(stone.charAt(0))] = 2;
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			switch (input) {
			case "R":
				
			}
		}
	}
}
