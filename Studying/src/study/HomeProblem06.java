package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class HomeProblem06 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 먼저 문제를 해결하기 위해서는 sort 작업이 필수적이다.
		// sort를 마친후 양 끝단을 잘라버린 후에 sum을 계산해서 해당 값의 평균을 구해 round를 통해 반올림한다.
		
		int n = Integer.valueOf(bf.readLine());
		// 25명 -> 3.75명(반올림 4명);
		long slide = Math.round((n * 3)/20.0);
		double sum = 0;
		ArrayList<Integer> arr = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++) {
			arr.add(Integer.valueOf(bf.readLine()));
		}
		Collections.sort(arr);
		for (int i = 0; i < n; i++) {
			// n : 20, slide : 3 이라고 가정
			// i = 0, 1, 2, 17, 18, 19
			if (i < slide || n - slide <= i) {
				continue;
			} else {
				sum += arr.get(i);
			}
		}
		bw.write(String.valueOf(Math.round(sum/(n-(slide*2)))));
		bw.flush();
		bf.close();
		bw.close();
	}
}
