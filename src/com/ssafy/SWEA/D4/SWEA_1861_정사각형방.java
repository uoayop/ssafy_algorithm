package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static boolean[][] visited;
	static int n, answer_depth, answer_start, arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		/* 입력 받기 */
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visited  = new boolean[n][n];
			answer_depth = 0;						/* 전역변수 : 이동 횟수 저장 */
			answer_start=Integer.MAX_VALUE;  		/* 전역변수 : 이동 횟수가 같을 때 가장 작은 방 번호 저장*/
			
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			/* 각 위치에 대한 체크를 해줌 */
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					depthCheck(1, i, j, arr[i][j]); /* 이동 횟수, 현재 좌표, 현재 방에 적힌 숫자 */
				}
			}
			bw.write("#"+t+" "+answer_start+" "+answer_depth+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}

	private static void depthCheck(int depth, int x, int y, int start) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1}; /* 상하좌우 */
		
		visited[x][y] = true;	/* 현재 좌표 방문 체크 */
		
		for (int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {					// 상하좌우로 이동한 좌표가 범위 내에 있고
				if (!visited[nx][ny] && arr[nx][ny] == arr[x][y] + 1) {		// 방문 안한 곳이고, 방 적힌 숫자가 1 클 때
					depthCheck(depth + 1, nx, ny, start);					// 이동 횟수를 1 늘려서 방문
				}
			}
		}
		
		if (answer_depth == depth) {						// 이동 횟수 비교
			answer_start = Math.min(answer_start, start);
		} else if (answer_depth <= depth){
			answer_depth = depth;
			answer_start = start;
		}
		
		visited[x][y] = false;
	}

}
