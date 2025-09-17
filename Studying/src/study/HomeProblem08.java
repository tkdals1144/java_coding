package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class HomeProblem08 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 단순히 값이 같은걸로는 찾아낼 수 없다.
		// 객체를 큐에 넘겨줄 수 있을까?
		// 알고리즘은 문서의 중요도가 높은 다른 문서가 있다면 출력하지 않는다는 것이다.
		// 그렇다면 중요도가 높은 문서가 있는지 뒤의 문서와 비교대조 하는방식으로 찾는게 가능하다.
		// 현재의 인덱스와 실제로 알고리즘의 적용 후의 인덱스가 중요하다.
		int test = Integer.valueOf(bf.readLine());
		
		// 기본적인 테스트케이스의 개수를 설정합니다.
		for (int i = 0; i < test; i++) {
			// index => 뽑혀나온 순서
			String[] MN = bf.readLine().split(" ");
			// 문서의 개수 N개
			int N = Integer.valueOf(MN[0]);
			// 알고리즘 적용 후 출력되는 순서를 알고 싶은 현재의 M번째 인덱스
			int M = Integer.valueOf(MN[1]);
			
			// 각 자료들의 중요도 나열
			String[] ar = bf.readLine().split(" ");
			
			Queue<IndexAndNumber> queue = new LinkedList<>();
			
			// (중요도, 현재인덱스)
			for (int j = 0; j < N; j++) {
				queue.add(new IndexAndNumber(Integer.valueOf(ar[j]), j));
			}
			
			int index = 0;
			
			while (!queue.isEmpty()) {
				// 중요도가 더 높은 문서가 있는지 먼저 확인한다.
				IndexAndNumber current = queue.poll();
				boolean isMax = true;
				
				for (IndexAndNumber p : queue) {
					if (p.x > current.x) {
						isMax = false;
						break;
					}
				}
				if (isMax) {
					// 가장 중요도가 크다면 뽑혀나갈 테니까
					index++;
					if (current.y == M) {
						sb.append(index).append("\n");
						break;
					}
				} else {
					queue.add(current);
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		bf.close();
	}
	static class IndexAndNumber {
		public int x, y;

		public IndexAndNumber(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
