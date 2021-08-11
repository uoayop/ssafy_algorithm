package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233_9일차_사칙연산유효성검사 {
	static int N;
	static String[] tree;
	static boolean isNum;	// 이전 노드가 숫자였는지 판단
	static boolean result;	// 연산이 가능한 지 판단
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t=1; t<=10; t++) {
            N = Integer.parseInt(br.readLine());
            tree = new String[N+1];
             
            for (int i=1; i<=N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());  		 // 정점 번호
                String order = st.nextToken();                      // 정점 알파벳
                 
                tree[index] = order;    // tree[번호] = 알파벳
            }
            result = true;  	// 연산 가능한 지 판단
            isNum = false;  	// 숫자와 문자가 번갈아서 나오는지 판단
            visit(1);   		// 루트 정점부터 중위순회 (LDR)
             
            System.out.print("#"+t+" ");
            if (result) System.out.println("1");
            else System.out.println("0");
        }
    }
     
    public static void visit(int index) {   		//LDR
        if (index * 2 <= N) visit(index * 2);    	// 왼쪽 자식부터 방문
         
        System.out.print(tree[index] + " ");
        
        // 만약 부모 노드가 숫자일 때
        if (isNumber(tree[index], tree[index].length())) {
            if (isNum) {    				// 이전 노드가 숫자였다면
                result = false;    			 // 연산 불가
                return;         
            }
            isNum = true;
        } else {    // 부모 노드가 연산일 때
            if (!isNum) {   				// 이전 노드가 연산이라면
                result = false;     		// 연산 불가
                return;
            }
            isNum = false;
        }
         
        if (index * 2 + 1 <= N) visit(index * 2 + 1);    // 오른쪽 자식 방문
    }
     
     static boolean isNumber(String s, int l) {
        if(s == null || l == 0)
          return false;
         
        for(char c: s.toCharArray()) {
          if(!Character.isDigit(c))
            return false;
        }
        return true;
      }
}

/*
9
1 *
2 +
3 -
4 /
5 2
6 6
7 4
8 8
9 7
*/
