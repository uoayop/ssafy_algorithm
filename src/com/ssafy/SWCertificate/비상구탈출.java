package com.ssafy.SWCertificate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 비상구탈출 {
	public static class pos{
		int x, y;
		
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int ans;
	public static ArrayList<pos> exits, humans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			ans = Integer.MAX_VALUE;
			exits = new ArrayList<>();
			humans = new ArrayList<>();
			
			int n = Integer.parseInt(br.readLine());
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {	// 사람
						humans.add(new pos(i, j));
					} else if  (temp == 2) {	// 비상구
						exits.add(new pos(i, j));
					}
				}
			}
			
			boolean[] selected = new boolean[humans.size()];
			makeSubset(selected, 0, 0);
			
			bw.write("#"+t+" "+ans+"\n");
			bw.flush();
		}
	}
	
	private static void makeSubset(boolean[] selected, int index, int cnt) {
		if (index == humans.size()) {
			go(selected);
			return;
		}
		
		selected[index] = true;
		makeSubset(selected, index+1, cnt+1);
		selected[index] = false;
		makeSubset(selected, index+1, cnt);
	}

	private static void go(boolean[] selected) {
		ArrayList<Integer> firstDis = new ArrayList<>();
		ArrayList<Integer> secondDis = new ArrayList<>();
		
		for (int i=0; i<humans.size(); i++) {
			// i번째 사람
			pos exitChoice = selected[i]? exits.get(0) : exits.get(1);	
			// true이면 첫번째 비상구, false이면 두번째 비상구
			
			int dis = getDistance(humans.get(i), exitChoice);
			if (selected[i]) {
				firstDis.add(dis);
			}
			else if (!selected[i]) {
				secondDis.add(dis);
			}
		}
		
		int dis = 0;
		if (!firstDis.isEmpty())
			dis = Math.max(dis, getTime(firstDis));
		if (!secondDis.isEmpty())
			dis = Math.max(dis, getTime(secondDis));
		
		ans = Math.min(dis, ans);
	}

	private static int getTime(ArrayList<Integer> dis) {
		Collections.sort(dis);
		
		int t = 0;
		for (int d: dis) {
			if (d > t) t = d + 1;
			else t++;
		}
		return t;
	}

	private static int getDistance(pos h, pos e) {
		return Math.abs(h.x-e.x) + Math.abs(h.y-e.y);
	}
}
