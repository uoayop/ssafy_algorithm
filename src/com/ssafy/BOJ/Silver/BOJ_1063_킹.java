package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1063_킹 {
	public static Map<String, int[]> dir;
	public static class pos{
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		dir = new HashMap<>();
		makedir();
		// 'A' = 65
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] k = st.nextToken().toCharArray();
		char[] r = st.nextToken().toCharArray();
		int n = Integer.parseInt(st.nextToken());
		
		pos king = new pos(Math.abs(8-(k[1]-'0')), k[0]-65);
		pos rock = new pos(Math.abs(8-(r[1]-'0')), r[0]-65);
		
		for (int i=0; i<n; i++) {
			String order = br.readLine();
			
			int dx = dir.get(order)[0];
			int dy = dir.get(order)[1];
			
			int nx = king.x + dx;
			int ny = king.y + dy;
			
			 if (nx < 0 || ny < 0 || 7 < nx || 7 < ny) {
				// 범위 넘어가면 다음 이동
				continue;
			} else if (rock.x == nx && rock.y == ny) {
				// 다음 위치가 돌이랑 같다면
				if (nx + dx < 0 || ny + dy < 0 || 7 < nx + dx || 7 < ny + dy) {
					// 돌의 다음 위치가 범위를 넘어가면 
					continue;
				} else {
					// 돌의 위치가 다음 범위를 넘어가지 않으면
					rock.x += dx; rock.y += dy;
					king.x += dx; king.y += dy;
				}
			} else {
				// 범위 내에 있고, 다음 위치가 돌도 아니라면
				king.x += dx; king.y += dy;
			}


			System.out.println(king.x +" " + king.y);
			System.out.println(rock.x + " " + rock.y);
		}
		System.out.printf("%c%d\n",king.y + 65, Math.abs(8-king.x));
		System.out.printf("%c%d\n",rock.y + 65, Math.abs(8-rock.x));
	}
	
	private static void makedir() {
		String[] str = {"R","L","B","T","RT","LT","RB","LB"};
		int[][] xy = {{0, 1},{0, -1},{1, 0},{-1, 0},{-1, 1},{-1, -1},{1, 1},{1, -1}};
		
		for (int i=0; i<8; i++) {
			dir.put(str[i], xy[i]);
		}
	}
}
