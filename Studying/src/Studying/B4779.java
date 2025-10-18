package Studying;
import java.util.*;
import java.io.*;

public class B4779 {
	
	static String gap(int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) sb.append(" ");
		return sb.toString();
	}
	
	static String func(int N) {
		if (N == 0) {
			return "-";
		}
		int num = (int)Math.pow(3, N);
		return func(N-1) + gap(num/3) + func(N-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			System.out.println(func(N));
		}
		
	}
}
