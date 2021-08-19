package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	public static int R,C,cnt;
	public static int[] dx = {-1, 0, 1};
	public static char[][] map;
	public static Stack<int []> stack;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		cnt = 0;
		for (int r=0; r<R; r++) {
			stack = new Stack<>();
			if (go(r,0)) {
				while (!stack.isEmpty()) {
					int []want = stack.pop();
					map[want[0]][want[1]] = '.';
				}
			} 	// go(row, col) : 각 행에 대해서 열을 하나씩 늘리면서 체크해주려고 함
		}
		System.out.println(cnt);
	}

	private static boolean go(int r, int c) {
		if (c==C) {	// 만약 열이 C라면 끝까지 도착했다는 의미이므로 cnt++
			cnt ++;
			return false;	// 끝까지 도착했으니까 다음 경우는 고려하지 않아도 됨
		}
		
		if (r < 0 || r >= R || c < 0 || c >= C) {
			// 범위 바깥으로 넘어갈 경우엔 다음 경우 고려
			return true;
		}
		
		if (map[r][c]=='x') {
			// 건물을 만나면 다음 경우 고려
			return true;
		} else { // 이동이 가능하다면 
			// 파이프는 겹쳐질 수 없으므로 해당 땅을 x로 바꿔줌
			map[r][c]= 'x';
			int []temp = {r,c};
			stack.add(temp);
			
//			System.out.printf("r: %d / c: %d\n",r,c);
//			for (char[] row:map) {
//				for (char col: row) {
//					System.out.print(col);
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			if (go(r-1, c+1)) {	// 오른쪽 위
				if (go(r, c+1)) {	// 오른쪽
					if (go(r+1, c+1)) {	// 오른쪽 아래 순으로 탐색
						return true;
					}
				}
			}
		}
		return false;
	}
}
