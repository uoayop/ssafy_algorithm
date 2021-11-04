package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16165_걸그룹마스터준석이 {
	public static void main(String[] args) throws Exception {
		// 걸그룹 수 B, 맞혀야 할 문제의 수 M
		// 퀴즈가 0이면 팀 이름 => 멤버 이름 사전 순으로 출력
		// 퀴즈가 1이면 멤버 이름 => 속한 팀 이름
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> getTeam = new HashMap<>();
		Map<String, ArrayList<String>> getMember = new HashMap<>();
		
		while (n-- > 0) {
			String teamName = br.readLine();
			ArrayList<String> temp = new ArrayList<>();
			
			int cnt = Integer.parseInt(br.readLine());
			while (cnt-- > 0) {
				String MemberName = br.readLine();
				temp.add(MemberName);
				getTeam.put(MemberName, teamName);
			}
			Collections.sort(temp);
			getMember.put(teamName, temp);
		}
		
		while (m-- > 0) {
			String target = br.readLine();
			int quiz = Integer.parseInt(br.readLine());
			
			if (quiz == 0) { // 멤버 출력
				for (String member: getMember.get(target))
					bw.write(member+"\n");
			} else {	// 그룹 출력
				bw.write(getTeam.get(target)+"\n");
			}
		}
		bw.flush();
		
	}
}
