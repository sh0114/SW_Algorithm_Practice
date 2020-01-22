package dp;

import java.util.*;
import java.io.*;

public class p1149 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n+1][3];
		int[][] dp = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		for(int i=1; i<=n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
		}
		
		
		int min = 9999999;
		
		for(int i=0; i<3; i++) {
			if(min > dp[n][i]) {
				min = dp[n][i];
			}
		}
		System.out.println(min);
		br.close();
	}
}
