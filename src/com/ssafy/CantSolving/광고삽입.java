package com.ssafy.CantSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 광고삽입 {
	// 못풀겠어요......................
	public static void main(String[] args){
		System.out.println(solution("02:03:55", "00:14:15", new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
	}
	
	public static class play implements Comparable<play>{
		int sh, sm, ss;
		int eh, em, es;
		
		public play(int sh, int sm, int ss, int eh, int em, int es) {
			super();
			this.sh = sh;
			this.sm = sm;
			this.ss = ss;
			this.eh = eh;
			this.em = em;
			this.es = es;
		}

		@Override
		public int compareTo(play o) {
			// 끝나는 시간이 빠른 순서대로 정렬
			if (eh == o.eh) {
				if (em == o.em) {
					return es - o.es;
				}
				return em - o.em;
			}
			return eh - o.eh;
		}
		
		public String getStartTime() {
			return sh+""+sm+""+ss;
		}
		
		public String getEndTime() {
			return eh+""+em+""+es;
		}

		@Override
		public String toString() {
			return "play [sh=" + sh + ", sm=" + sm + ", ss=" + ss + ", eh=" + eh + ", em=" + em + ", es=" + es + "]";
		}
	}
	
	public static ArrayList<play> list = new ArrayList<>();
	
	public static String solution(String play_time, String adv_time, String[] logs) {
        timesplit(logs);
        Collections.sort(list);
        
//        for (play p: list) {
//        	System.out.println(p);
//        }
        
        ArrayList<play> ans = findTime();
        for (play p: ans) {
        	System.out.println(p);
        }
        
        System.out.println(adv_time);
        String[] temp = adv_time.split(":");
        int ah = Integer.parseInt(temp[0]), am = Integer.parseInt(temp[1]), as = Integer.parseInt(temp[2]);
        
        play fst = ans.get(0);
        int firstTime = getSecond(fst.eh, fst.em, fst.es) - getSecond(fst.sh,fst.sm, fst.ss);
        int AdTime = getSecond(ah, am, as);
        

		String answer = "";
        if (firstTime > AdTime) {
        	
        } else {
        	answer = fst.sh+":"+fst.sm+":"+fst.ss;
        }
        
        
        return answer;
    }

	private static int getSecond(int h, int m, int s) {
		return h * 3600 + m * 60 + s;
	}

	private static ArrayList<play> findTime() {
		ArrayList<play> times = new ArrayList<>();
		for (int i=0; i<list.size()-1; i++) {
			play curr = list.get(i), next = list.get(i+1);
			
			int currEndTime = Integer.parseInt(curr.getEndTime());
			int nextStartTime = Integer.parseInt(next.getStartTime());
			
			if (currEndTime > nextStartTime) {
				times.add(curr);
				if (i == list.size()-2) times.add(next);
			} else {
				times = new ArrayList<>();
			}
		}
		return times;
	}

	private static void timesplit(String[] logs) {
		for (String log: logs) {
			String[] row = log.split("-");
			String[] start = row[0].split(":");
			String[] end = row[1].split(":");
			
			list.add(new play(
					Integer.parseInt(start[0]), Integer.parseInt(start[1]), 
					Integer.parseInt(start[2]), Integer.parseInt(end[0]), 
					Integer.parseInt(end[1]), Integer.parseInt(end[2])));
		}
	}
}
