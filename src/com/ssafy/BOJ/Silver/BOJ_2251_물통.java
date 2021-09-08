package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {
	public static Queue<int[]> q;
	public static int[] nums;
	public static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> ans = new ArrayList<>();
		list = new ArrayList<>();
		nums = new int[] {a, b, c};
		int[] start = {0, 0, c};
		
		q = new LinkedList<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			int x = curr[0], y = curr[1], z = curr[2];
			
			if (x == 0) {
				if (!ans.contains(z)) {
					ans.add(z);
				}
			}
			
			else {
				movewater(curr, 0, 1);
				movewater(curr, 0, 2);
			}
			
			if (y != 0) {
				movewater(curr, 1, 0);
				movewater(curr, 1, 2);
			}
			
			if (z != 0) {
				movewater(curr, 2, 0);
				movewater(curr, 2, 1);
			}		
		}
		
		Collections.sort(ans);
		for (int x: ans) {
			System.out.print(x+" ");
		}
		System.out.println();
	}

	private static void movewater(int[] temp, int from, int to) {
		int[] curr = Arrays.copyOf(temp, temp.length);
		
		if (curr[from] + curr[to] < nums[to]) {
			curr[to] = curr[from] + curr[to];
			curr[from] = 0;
		} else {
			curr[from] = curr[from] - (nums[to]-curr[to]);
			curr[to] = nums[to];
		}
		
		for (int[] row: list) {
			if (curr[0] == row[0] && curr[1] == row[1] && curr[2] == row[2]) {
				return;
			}
		}
		q.add(curr);
		list.add(curr);
	}
}
