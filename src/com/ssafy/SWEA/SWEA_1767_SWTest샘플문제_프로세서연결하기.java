package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1. 비가장자리 코어를 리스트에 담기
2. 코어리스트로 부분집합 처리하여 시도해볼 코어 선택하기
3. 선택한 코어마다 4방향 전선 놓기 시도
- 전선 해당 방향으로 놓을 수 있는지 체크
	- 가능 : 전선 놓기 : NxN 배열에 표시
	- 불가능 : 다음 방향
4. 연결된 코어의 개수가 갱신될 때 전선의 길이의 합 체크 
 * */

public class SWEA_1767_SWTest샘플문제_프로세서연결하기 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, map[][], max, min, totalCnt;	
	// max: 연결한 최대 코어 개수
	// min: 최소 전선 길이의 합
	// totalCnt : 가장자리가 아닌 코어 개수
	static ArrayList<int[]> list;	// 가장자리가 아닌 코어들의 위치 저장한 리스트
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					// 가장자리의 코어는 저장하지 않음
					if (i==0 || i==N-1 || j==0 || j==N-1) continue;
					
					if (map[i][j] == 1) {	// 코어일 때
						list.add(new int[] {i,j});
						totalCnt++; // 가장자리가 아닌 코어 개수
					}
				}
			}
			
			go(0, 0);
			out.write("#"+tc+" "+min+"\n");
			out.flush();
		}
	}
	
	
	private static void go(int index, int cCnt) {
		// index: 리스트의 인덱스
		// cCnt : 부분 집합의 개수 (어떤 코어를 포함시킬지)
		
		if (index == totalCnt) {
			// 모든 코어에 대해서 고려를 했다면
			
			int res = getLength();	// [전선의 총 길이의 합 구하기] : getLength
			// 선택된 코어 개수로 max 갱신
			if (max < cCnt) {	// 코어 개수가 더 많으면 갱신
				max = cCnt;
				min = res;
			} else if (max == cCnt) {
				// 코어 개수가 같다면 비교 후 더 작을 때만 갱신
				if (min > res) min = res;
			}
			return;
		}
		
		
		int[] curr = list.get(index);
		int r = curr[0], c = curr[1];
		
		// [index 코어 선택] : 4방향으로 시도
		for (int d=0; d<4; d++) {
			if (isAvailable(r, c, d)) {
				setStatus(r, c, d, 2); // [전선 놓기] : setStatus (0->2)
				// 0: 빈칸, 1: 코어, 2: 전선
				
				// [다음 코어로] : 다음 인덱스로 이동, 코어 개수+1
				go(index+1, cCnt+1);
				
				setStatus(r, c, d, 0); // [놓았던 전선 지우기] : setStatus (2->0)
			}
		}
		
		// [index 코어 미선택] : 다음 인덱스로 이동, 코어 개수 그대로
		go(index+1, cCnt);
	}

	private static boolean isAvailable(int r, int c, int d) {
		// 현재 코어 위치 : (r,c) 
		// 코어 방향 : d
		
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc<0 || nc >=N) {
				break; // 다 하고 경계를 벗어남
			}
			
			if (map[nr][nc] >=1) {
				return false;	
				// 코어가 있거나 전선이 있으면 이동할 수 없음
			}
		}
		return true; // 끝까지 이동 가능
	}

	private static void setStatus(int r, int c, int d, int s) {
		// 현재 코어 위치 : (r,c) 
		// 코어 방향 : d
		// 어떤 값으로 변경할지 : s
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc<0 || nc >=N) break; // 다 하고 경계를 벗어남
			
			map[nr][nc] = s;
		}
	}
	
	private static int getLength() {
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 2) cnt++;
			}
		}
		return cnt;
	}
}
