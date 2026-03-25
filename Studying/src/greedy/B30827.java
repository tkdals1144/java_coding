package greedy;
import java.io.*;
import java.util.*;

public class B30827 {
    static int N, K;
    static int[][] meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1. 종료 시간 기준 오름차순, 종료 시간이 같다면 시작 시간 기준 오름차순 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0]; // 종료시간 같으면 시작시간은 늦을수록 유리 (선택폭 확대)
            return a[1] - b[1];
        });

        // 2. K개의 회의실 종료 시간을 저장할 배열
        int[] rooms = new int[K];
        int count = 0;

        for (int i = 0; i < N; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // 3. 최적의 회의실 찾기
            // "start보다 작으면서 그중 가장 큰 값"을 가진 회의실 인덱스를 찾습니다.
            int targetIdx = -1;
            int maxFinishTime = -1;

            for (int j = 0; j < K; j++) {
                if (rooms[j] < start) {
                    if (rooms[j] > maxFinishTime) {
                        maxFinishTime = rooms[j];
                        targetIdx = j;
                    }
                }
            }

            // 4. 배정 가능하다면 갱신
            if (targetIdx != -1) {
                rooms[targetIdx] = end;
                count++;
            }
        }

        System.out.println(count);
    }
}