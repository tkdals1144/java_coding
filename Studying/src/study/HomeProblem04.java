package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HomeProblem04 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(bf.readLine());
		ArrayList<Number> number = new ArrayList<>(testCase);
		for (int i = 0; i < testCase; i++) {
			String numXY = bf.readLine();
			String[] numSplit = numXY.split(" ");
			number.add(new Number(Integer.parseInt(numSplit[0]), Integer.parseInt(numSplit[1])));
		}
		Collections.sort(number, new Comparator<Number>() {

			@Override
			public int compare(Number o1, Number o2) {
				// 왼쪽값이 크면 양수반환, 오른쪽값이 크면 음수 반환, 동일하면 0반환
				// 양수반환시 첫 객체가 뒤로가게끔 알고리즘이 짜여져있음
				int num = Integer.compare(o1.getX(), o2.getX());
				if (num == 0) {
					num = Integer.compare(o1.getY(), o2.getY());
				}
				return num;
			}
		});
		for (Number n : number) {
			bw.write(n.toString());
		}
		bw.flush();
		bf.close();
		bw.close();
	}
	public static class Number {
		private int x;
		private int y;
		
		public Number(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " " + y + "\n";
		}
	}
}
