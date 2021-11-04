package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18235_지금만나러갑니다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// 1일차엔 1칸, 2일차엔 2칸 .. 
		
		int[] dir = {-1, 1};
		int ans = -1;
		// 20일동안 a가 갈 수 있는 칸 체크
		boolean[][] goA = new boolean[20][n+1];
		LinkedList<int[]> q = new LinkedList<>();
		q.add(new int[] {0, a});	// day, pos
		goA[0][a] = true;
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int day = temp[0], curr = temp[1];
			int dis = (int) Math.pow(2, day);
			
			for (int d = 0; d<2; d++) {
				int next = curr + (dir[d] * dis);
				if (0 < next && next <= n) {
					if (!goA[day+1][next]) {
						goA[day+1][next] = true;
						q.add(new int[] {day+1, next});
					}
				}
			}
		}
		
		// 20일동안 b가 갈 수 있는 칸 체크
		boolean[][] goB = new boolean[20][n+1];
		q = new LinkedList<>();
		q.add(new int[] {0, b});
		goB[0][b] = true;
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int day = temp[0], curr = temp[1];
			int dis = (int) Math.pow(2, day);
			
			if (goA[day][curr]) {
				ans = day; 
				break;
			}
			
			for (int d = 0; d<2; d++) {
				int next = curr + (dir[d] * dis);
				if (0 < next && next <= n) {
					if (!goB[day+1][next]) {
						goB[day+1][next] = true;
						q.add(new int[] {day+1, next});
					}
				}
			}
		}
		
		
		bw.write(ans+"\n");
		bw.flush();
		/*LinkedList<int[]> q = new LinkedList<>();
		HashMap<int[], Boolean> visited = new HashMap<>();
		q.add(new int[] {a, b});
		
		int day = 0;
		outer: while (!q.isEmpty()) {
			int size = q.size();
			int move = (int) Math.pow(2, day);
			while (size--> 0) {
				int[] curr = q.poll();
				int x = curr[0], y = curr[1];
				visited.put(new int[] {x, y}, true);
				
				if (x == y) {
					bw.write(day+"\n");
					break outer;
				}
				
				boolean aF = false, aB = false, bF = false, bB = false;
				if (x + move <= n) aF = true;
				if (x - move > 0) aB = true;
				if (y + move <= n) bF = true;
				if (y - move > 0) bB = true;
				
				if (aF && bF) {
					if (visited.get(new int[] {x+move, y+move}) == null) {
						q.add(new int[] {x + move, y + move});
					}
				}
				if (aF && bB)
					if (visited.get(new int[] {x + move, y - move}) == null) {
						q.add(new int[] {x + move, y - move});
					}
				if (aB && bF)
					if (visited.get(new int[] {x - move, y + move}) == null) {
						q.add(new int[] {x - move, y + move});
					}
				if (aB && bB)
					if (visited.get(new int[] {x - move, y - move}) == null) {
						q.add(new int[] {x - move, y - move});
					}
				
				if (!aF && !aB) {
					bw.write("-1\n");
					break outer;
				}
			}
			
			day++;
			if (day >= 20) {
				bw.write("-1\n");
				break;
			}
		}
		bw.flush();*/
	}
}
