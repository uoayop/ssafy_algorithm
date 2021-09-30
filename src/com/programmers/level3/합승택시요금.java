package com.programmers.level3;

import java.util.Arrays;

public class 합승택시요금 {
	public static int INF = 987654321;
	public static int [][] map;
	
	public static void main(String[] args){
		System.out.println(solution(6, 4, 6, 2, new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		init(n, fares);
		// 플로이드-와샬 알고리즘 사용
		
		printMap();

		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					// map[from][to] = from에서 to까지의 최단거리
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		printMap();
		
		int answer = INF;
		
		for (int i=1; i<=n; i++) {	// map[s][i] : s 정점부터 i정점까지 택시를 같이 탈 때 최소 비용
			if (map[s][i] == INF || map[i][a] == INF || map[i][b] == INF) continue;
			
			int temp = map[s][i] + map[i][a] + map[i][b];
			answer = Math.min(answer, temp);
		}
		
		return answer;
	}

	private static void printMap() {
		for (int[] row: map) {
			for (int col: row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void init(int n, int[][] fares) {
		map = new int[n+1][n+1];
		for (int i=0; i<=n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		for (int[] row: fares) {
			map[row[0]][row[1]] = row[2];
			map[row[1]][row[0]] = row[2];
		}
	}
}
