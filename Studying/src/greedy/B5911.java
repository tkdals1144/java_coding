package greedy;
import java.io.*;
import java.util.*;

public class B5911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] gifts = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gifts[i][0] = Integer.parseInt(st.nextToken()); // 선물 가격
            gifts[i][1] = Integer.parseInt(st.nextToken()); // 배송비
        }

        // 전체 선물을 "정가(선물+배송비)" 기준으로 오름차순 정렬
        Arrays.sort(gifts, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        int maxPeople = 0;

        // i번째 선물을 할인받는 경우를 모두 시도
        for (int i = 0; i < N; i++) {
            long totalCost = (gifts[i][0] / 2) + gifts[i][1]; // i번째 할인 적용
            int count = 0;

            if (totalCost <= B) {
                count = 1;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue; // 이미 할인해서 산 건 건너뜀
                    
                    long nextCost = gifts[j][0] + gifts[j][1];
                    if (totalCost + nextCost <= B) {
                        totalCost += nextCost;
                        count++;
                    } else {
                        break; // 예산 초과 시 중단
                    }
                }
            }
            maxPeople = Math.max(maxPeople, count);
        }

        System.out.println(maxPeople);
    }
}
