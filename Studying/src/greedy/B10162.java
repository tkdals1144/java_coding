package greedy;
import java.io.*;
import java.util.*;
public class B10162 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int a = T / 300;
		int b = (T % 300) / 60;
		int c = ((T % 300) % 60) / 10;
		if (((T % 300) % 60) % 10 != 0) System.out.println(-1);
		else System.out.println(a + " " + b + " " + c);
	}
}
