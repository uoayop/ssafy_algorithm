package com.ssafy.SWEA.D6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// System.out.println 과 BufferedWriter 차이가 두 배 이상 난다!
// 주의하자~~~~~

// 3,397 ms
//public class SWEA_1263_8일차_사람네트워크2 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//         
//        for (int t=1; t<=T; t++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(st.nextToken());
//             
//            int[][] map = new int[n][n];
//            int[][] d = new int[n][n];
//            int INF = 10000;
//             
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//                    map[i][j] = Integer.parseInt(st.nextToken());
//                    if (i==j) d[i][j] = 0;
//                    else d[i][j] = map[i][j] == 0? INF : map[i][j];
//                     
//                }
//            }
//             
//            for (int k=0; k<n; k++) {            // 경유지
//                for (int i=0; i<n; i++) {        // 출발지
//                    if (i==k) continue;
//                    for (int j=0; j<n; j++) {    // 도착지
//                        if (j==i || j==k) continue;
//                        d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
//                    }
//                }
//            }
//             
//            int ans = INF;
//            for (int[] row: d) {
//                int sum = 0;
//                for (int col: row) {
//                    sum += col;
//                }
//                ans = Math.min(sum, ans);
//            }
//            System.out.println("#"+t+" "+ans);
//        }
//    }
//}


// 1,568 ms
public class SWEA_1263_8일차_사람네트워크2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
         
        for (int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
             
            int[][] map = new int[n][n];
            int[][] d = new int[n][n];
            int INF = 10000;
             
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i==j) d[i][j] = 0;
                    else d[i][j] = map[i][j] == 0? INF : map[i][j];
                     
                }
            }
             
            for (int k=0; k<n; k++) {            // 경유지
                for (int i=0; i<n; i++) {        // 출발지
                    for (int j=0; j<n; j++) {    // 도착지
                        d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
                    }
                }
            }
             
            int ans = INF;
            for (int[] row: d) {
                int sum = 0;
                for (int col: row) {
                    sum += col;
                }
                ans = Math.min(sum, ans);
            }
            
            bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
    }
}
