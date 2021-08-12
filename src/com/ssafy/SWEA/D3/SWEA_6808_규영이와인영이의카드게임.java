package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {
	public static int[] orders;
	public static boolean[] visited = new boolean[9];
	public static ArrayList<Integer> c1, c2;
	public static int gscore = 0, iscore = 0;
	public static int gwin = 0, iwin = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			gwin = 0; iwin = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			c1 = new ArrayList<>();
			c2 = new ArrayList<>();

			for (int i=1; i<=18; i++) {
				c2.add(i);
			}
			
			for (int i=0; i<9; i++) {
				 int temp = Integer.parseInt(st.nextToken());
				 c1.add(temp);
				 c2.remove(c2.indexOf(temp));
			}
		
			orders = new int[9];
			makePermutation(0);
			
			System.out.printf("#%d %d %d\n",t,gwin,iwin);
		}
	}

	private static void makePermutation(int index) {
		if (index == c2.size()) {
			gscore = 0; iscore = 0;
			for (int j = 0; j < 9; j++) {
				ScoreCheck(j, orders[j]);
			}

			if (gscore > iscore) gwin++;
			else if (gscore < iscore) iwin++;
			return;
		}
		
		for (int i=0; i<c2.size(); i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			orders[index] = i;
			makePermutation(index+1);
			visited[i] = false;
		}
	}

	private static void ScoreCheck(int gindex, int index) {
		int gs = c1.get(gindex);
		int is = c2.get(index);
		
		if (gs < is) {
			// 인영이 점수가 더 높으면
			iscore += gs + is;
		} else if (gs > is) {
			gscore += gs + is;
		}		
	}
}

/*
 * 
4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18	
*/
