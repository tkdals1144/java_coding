package Studying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	int n = 5;
    	int[][] arr = {
    	    {1, 2, 3, 4, 5},
    	    {5, 6, 7, 8, 9},
    	    {9, 8, 7, 6, 5},
    	    {5, 4, 3, 2, 1},
    	    {1, 1, 1, 1, 1}
    	};

    	int[] dx = {-1, 1, 0, 0}; // 상, 하
    	int[] dy = {0, 0, -1, 1}; // 좌, 우

    	int x = 2, y = 2; // 기준 좌표 (중앙 7)

    	for (int dir = 0; dir < 4; dir++) {
    		// nx = 2 + dx[0] = 1
    		// ny = 2 + dy[0] = 2
    	    int nx = x + dx[dir];
    	    int ny = y + dy[dir];

    	    // 배열 범위 체크 (IndexOutOfBounds 방지)
    	    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
    	        System.out.println(arr[nx][ny]); 
    	    }
    	}
    }
}
