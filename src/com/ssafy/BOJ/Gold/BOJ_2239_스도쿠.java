package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_2239_스도쿠 {
	public static int[][] map;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		
		map = new int[9][9];
		for (int i=0; i<9; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j=0; j<9; j++) {
				map[i][j] = row[j] - '0';
			}
		}
	
		Stack<int []> stack = new Stack<>();
		
		int i = 0, j = 0, k = 1;
		while (i < 9 && j < 9) {
			
			int preX = i, preY = j;
			if (map[i][j] == 0) {
				// 들어갈 수 있는 값이 있는지 체크
				for (int t = k; t <=9; t++) {	// 1 ~ 9 체크
					if (check(i, j, t)) { // (i,j)에 k가 들어갈 수 있으면
						map[i][j] = t;
						stack.add(new int[] {i, j, t}); // stack에 추가
						
						if (j == 8) { j = 0; i ++; } 
						else { j ++; }
						
						k = 1;
						break;
					}
				}
				
				// 들어갈 수 있는 값이 없음
				if (map[preX][preY] == 0) {
					
					int[] temp = stack.pop(); // 이전 좌표, 값 꺼냄
					int tempX = temp[0], tempY = temp[1], tempV = temp[2];
					
					map[tempX][tempY] = 0; // 이전 좌표 초기화
					i = tempX;
					j = tempY;
					k = tempV + 1;
				}
			} 
			
			if (preY != j) continue;
			if (j == 8) { j = 0; i ++; } 
			else { j ++; }
		}

		printMap();
		br.close();
		bw.flush();
	}

	private static void printMap() throws Exception {
		for (int[] row: map) {
			for (int col: row) {
				bw.write(col+"");
			}
			bw.write("\n");
		}
	}

	private static boolean check(int x, int y, int v) {
		// 같은 행(x)에 v가 있는지 확인
		for (int col=0; col<9; col++) {
			if (map[x][col] == v) return false;
		}
		
		// 같은 열(y)에 v가 있는지 확인
		for (int row=0; row<9; row++) {
			if (map[row][y] == v) return false;
		}
		
		// 사각형에 v가 있는지 확인
		int squareX = x / 3, squareY = y / 3;
		for (int i=(3 * squareX); i<(3 * squareX) + 3; i++) {
			for (int j=(3 * squareY); j<(3 * squareY) + 3; j++) {
				if (map[i][j] == v) return false;
			}
		}
		
		return true;
	}
}
