package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class HomeProblem01 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>(testCase);
		
		for (int i = 0; i < testCase; i++) {
			int num = Integer.parseInt(bf.readLine());
			arr.add(num);
		}
		
		Collections.sort(arr);
		
		for (Integer num : arr) {
			// 정수를 문자열로 변환해서 출력해야 함
			bw.write(num.toString());
			bw.newLine();
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}
}
