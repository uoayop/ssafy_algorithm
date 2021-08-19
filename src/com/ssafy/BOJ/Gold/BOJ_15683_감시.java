package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	public static int n, m, ans = Integer.MAX_VALUE;
	public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	public static ArrayList<camera> cams = new ArrayList<>();
	public static int[][] map;
	
	public static class camera{
		int num;
		int x;
		int y;

		public camera(int num, int y, int x) {
			this.num = num;	// 카메라 번호
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5) {
					// 카메라일 때
					cams.add(new camera(map[i][j], i,j));
				}
			}
		}
		
		search(0, map);

	    System.out.println(ans);
	}

	private static void search(int index, int[][] maps) {
		int[][] visited = new int[n][m]; 	
		if (index == cams.size()) {	// 마지막 카메라까지 확인했다면
			int cnt = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if (maps[i][j] == 0) {cnt ++;}
				}
			}
			if (cnt < ans) {ans = cnt;}
		}
		else {
			camera curr = cams.get(index);
			int x = curr.x, y = curr.y, num = curr.num;
			// boolean이 아닌 이유는 cctv가 벽은 통과 못하지만, 다른 cctv는 통과하기 떄문
			
			if (num == 1) {	//1번 카메라이면
				for (int k = 0; k < 4; k++) {
	                for (int i = 0; i < n; i++) {
	                    visited[i] = Arrays.copyOf(maps[i], m);
	                }
	                check(visited, y, x, k);
	                search(index + 1, visited);
	            }
			} else if (num == 2) {	//2번 카메라이면
				for (int k = 0; k < 2; k++) {
	                for (int i = 0; i < n; i++) {
	                    visited[i] = Arrays.copyOf(maps[i], m);
	                }
	                check(visited, y, x,k);	// 정반대 방향
	                check(visited, y, x, k+2);
	                search(index + 1, visited);
	            }
			} else if (num == 3) {	//3번 카메라이면
				 for (int k = 0; k < 4; k++) {
	                 for (int i = 0; i < n; i++) {
	                     visited[i] = Arrays.copyOf(maps[i], m);
	                 }
	                 check(visited, y, x, k);
	                 check(visited, y, x, (k + 1) % 4);	// 직각
	                 search(index + 1, visited);
	             }
			} else if (num == 4) {	//4번 카메라이면
				 for (int k = 0; k < 4; k++) {
	                 for (int i = 0; i < n; i++) {
	                     visited[i] = Arrays.copyOf(maps[i], m);
	                 }
	                 check(visited, y, x, k);
	                 check(visited, y, x, (k + 1) % 4);	
	                 check(visited, y, x, (k + 2) % 4);	// 세 방향
	                 search(index + 1, visited);
	             }
			} else if (num == 5) {	//5번 카메라이면
				for (int i = 0; i < n; i++) {
	                visited[i] = Arrays.copyOf(maps[i], m);
	            }
	            check(visited, y, x, 0);
	            check(visited, y, x, 1);	
	            check(visited, y, x, 2);
	            check(visited, y, x, 3);	// 모든 방향
	            search(index + 1, visited);
			}
		}
	}

	private static void check(int[][] visited, int i, int j, int d) {
		while (true) {
			if (j<0 || j>=m || i<0 || i>=n) break;
			
			if (map[i][j] == 6) break;
			visited[i][j] = -1;
			
			i += dir[d][0]; j += dir[d][1];
		}
	}
}
//	private static void check4(camera curr) {
//		int max = 0; 
//		ArrayList<Integer> max_idx = new ArrayList<>();
//		
//		for (int i=0; i<4; i++) {
//			int nx = curr.x;
//			int ny = curr.y;
//			int cnt = 0;
//	
//			while (true) {
//				nx += dir[i][0];
//				ny += dir[i][1];
//				
//				if (nx >=0 && nx < n && ny >=0 && ny < m) {
//					if (map[nx][ny].equals("0")) { // 범위 안에 있고, 0일 때 
//						cnt++;
//					}
//					else {
//						break;
//					}
//				}
//				else {
//					break;
//				}
//			}
//
//			if (max>cnt) {
//				max = cnt;
//				max_idx = new ArrayList<>();
//				max_idx.add(i);
//			} else if (max==cnt) {
//				max_idx.add(i);
//			}
//		}
//		
//	}
