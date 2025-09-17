package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class HomeProblem03 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(bf.readLine());
		ArrayList<People> people = new ArrayList<>(testCase);
		
		for (int i = 0; i < testCase; i++) {
			String ageName = bf.readLine();
			String[] split = ageName.split(" ");
			people.add(new People(Integer.parseInt(split[0]), split[1]));
		}
		
		Collections.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		for (People p : people) {
			bw.write(Integer.toString(p.age) + " " + p.name + "\n");
		}
		bw.flush();
		bf.close();
		bw.close();
	}
	public static class People {
		private int age;
		private String name;
		
		public People(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		public int getAge() {
			return age;
		}
	}
}
