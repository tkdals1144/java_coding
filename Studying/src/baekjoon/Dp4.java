package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Dp4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		BigInteger[] big = new BigInteger[81];
		
		big[0] = new BigInteger("0");
		big[1] = new BigInteger("1");
		big[2] = new BigInteger("1");
		big[3] = new BigInteger("2");
		big[4] = new BigInteger("3");
		for (int i = 5; i < big.length; i++) {
			big[i] = big[i-1].add(big[i-2]);
		}
		
		BigInteger bigNum = big[N].multiply(new BigInteger("4")).add(big[N-1].multiply(new BigInteger("2")));
		System.out.println(bigNum);
	}
}
