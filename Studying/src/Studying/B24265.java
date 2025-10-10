package Studying;
import java.util.*;

public class B24265 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();
		long count = 0;
		for (long i = n - 1; i != 0; i--) {
			count+=i;
		}
		System.out.println(count);
		System.out.println(2);
	}
}
