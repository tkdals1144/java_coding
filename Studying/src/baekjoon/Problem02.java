package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		// 1, 2, 3 번 저장소 필요
		// {1 1 2 1 2 (1 1} {4) 1 1} 2
		// -> 7개, (1, 2), (1, 2)
		// 1번 저장소 -> 두 종류의 연속된 수의 총 개수
		// 2번 저장소 -> 연속되고 있는 두 수
		// 3번 저장소 -> 불연속된 값이 나오기 전의 연속된 수와 그 개수
		int max = 0;
		int total = 0;
		int[] nums = new int[2];
		// (수, 개수)
		int[] currentNums = new int[2];
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 현재 아무것도 없다면
			if (nums[0] == 0) {
				nums[0] = num;
				total++;
				currentNums[0] = num;
				currentNums[1] = 1;
			}
			// 현재 하나의 수만 연속되고 있다면
			else if (nums[0] == num && nums[1] == 0) {
				total++;
				currentNums[1] += 1;
			}
			// 두번째 수가 들어왔다면
			else if (nums[1] == 0) {
				nums[1] = num;
				total++;
				currentNums[0] = num;
				currentNums[1] = 1;
			}
			// 두번째 수가 들어왔고, 수가 이전과 동일하다면
			else if (currentNums[0] == num) {
				total++;
				currentNums[1] += 1;
			}
			// 완전히 새로운 수가 들어왔다면
			else if (nums[0] != num && nums[1] != num) {
				nums[0] = currentNums[0];
				nums[1] = num;
				if (total > max) max = total;
				total = currentNums[1] + 1;
				currentNums[0] = num;
				currentNums[1] = 1;
			} 
			// 이전과는 다르지만 연속된 수가 들어왔다면
			else {
				currentNums[0] = num;
				currentNums[1] = 1;
				total++;
			}
			if (i == (N - 1)) {
				if (total > max) max = total;
			}
		}
		
		System.out.println(max);
	}
}
