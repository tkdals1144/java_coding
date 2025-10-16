package Studying;
import java.util.*;
import java.io.*;

public class B25501 {
	
	static int count;
	// 입력값으로 String변수, int변수, int변수를 받아
    public static int recursion(String s, int l, int r){
    	count++;
    	// 만약 첫번째 int가 두번째 int보다 크거나 같다면 1 반환 (반을 넘어간다면 참이므로)
        if(l >= r) return 1;
        // 만약 다르고, 각 사이드쪽 값이 다르다면 0 반환
        else if(s.charAt(l) != s.charAt(r)) return 0;
        // 그것도 아니라면 재귀로 한번더 체크
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			count = 0;
			String input = br.readLine();
			sb.append(isPalindrome(input)).append(" ").append(count).append('\n');
		}
		System.out.println(sb.toString());
	}
}
