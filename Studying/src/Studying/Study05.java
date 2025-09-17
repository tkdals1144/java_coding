package Studying;

import java.util.*;
import java.io.*;

//&& arr[i][j] != arr[ni][nj]
public class Study05 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int max = 0;
		
		char[][] arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = bf.readLine().toCharArray();
		}
		
		char save = 'M';
		int num = 1;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// 0, 1일 경우 -> 0 0 0
		//                0
		//                0
		// 즉 하나를 고정시켜두고 나머지를 N까지 순회
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int ni = i + dx[k];
					int nj = j + dy[k];
					
					if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
						char temp = arr[i][j];
						arr[i][j] = arr[ni][nj];
						arr[ni][nj] = temp;
						
						for (int l = 0; l < N; l++) {
							char ch = arr[i][l];
							if (save != ch) {
								if (num > max) max = num;
								if (max == N) {
									System.out.println(max);
									return;
								}
								save = ch;
								num = 1;
							} else {
								num++;
							}
							if (l == (N - 1)) {
								if (num > max) max = num;
								if (max == N) {
									System.out.println(max);
									return;
								}
								save = 'M';
								num = 1;
							}
						}
						
						for (int h = 0; h < N; h++) {
							char ch = arr[h][j];
							if (save != ch) {
								if (num > max) max = num;
								if (max == N) {
									System.out.println(max);
									return;
								}
								save = ch;
								num = 1;
							} else {
								num++;
							}
							if (h == (N - 1)) {
								if (num > max) max = num;
								if (max == N) {
									System.out.println(max);
									return;
								}
								save = 'M';
								num = 1;
							}
						}
						
						arr[ni][nj] = arr[i][j];
						arr[i][j] = temp;
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
