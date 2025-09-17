package Studying;
import java.util.Scanner;

public class Study01 {
	   public static void main(String[] args) {
//	      두개의 자연수 A, B
//	      A = BC를 만족하는 자연수 C는 A의 약수
//	      A의 약수 즉 C들의 합은 f(A)
//	      g(5) = f(1) + f(2) + f(3) + f(4) + f(5)
//	      첫째 줄에는 테스트케이스의 개수
//	      둘째 줄부터는 자연수 N 입력
//	      g(N) 출력
	      int sum = 1;
	      int num = 0;
	      int arr[];
	      Scanner sc = new Scanner(System.in);
	      
	      int count = sc.nextInt();
	      for (int i = 0; i < count; i++) {
//	         num값은 자연수 N
	         num = sc.nextInt();
//	         총 num개의 f(N) 생성
	         arr = new int[num];
//	         f(1) = 1
	         arr[0] = 1;
	         System.out.println("arr[0]" + arr[0]);
//	         f(j)값을 구하는 과정
	         for (int j = 1; j <= num; j++) {
	            if (arr.length > 1) {
//	               f(2) = 3
//	               f(1) = arr[0], f(2) = arr[1]
//	               만약 j보다 낮은값의 k가 존재한다면 이를 for문에 태움
	               for (int k = 2; k <= j; k++) {
//	                  만약 arr[k]로 나누어진다면 이 값은 최소약수
	                  if (j % k == 0 && j != k) {
	                	  if ((j/k) % k == 0) {
//	 	                      최소약수가 존재한다면 이미 기존에 구해둔 배열값이 있을것이니 그것을 활용
	 	                      arr[j-1] = j + arr[(j/k) - 1];
//	 	                      System.out.println(arr[j-1]);
//	 	                      sum += j;
	 	                      sum += arr[j-1];
	 	                      System.out.println("arr[" + (j-1) +"]" +arr[j-1]);
	 	                      break;
	                	  }  else {
	                		  arr[j-1] = arr[(j/k) - 1] + arr[k-1] - 1 + j;
	                		  System.out.println("arr[" + (j-1) +"]" +arr[j-1]);
	                		  sum += arr[j-1];
	                		  break;
	                	  }
	                  }
//	                  마지막까지 돌렸는데도 약수가 존재하지 않는다면 해당 값은 소수
	                  if (k == j) {
	                     arr[j-1] = j + 1;
	                     sum += arr[j-1];
	                     System.out.println("arr[" + (j-1) +"]" +arr[j-1]);
	                     break;
	                  }
	               }
	            } else {
	               System.out.println(sum);
	            }
	         }
	         System.out.println(sum);
	         sum = 0;
	      }
	      sc.close();
	   }
	}

