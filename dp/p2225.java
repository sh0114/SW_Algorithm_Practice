package dp;

import java.util.*;
import java.io.*;

public class p2225 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[k+1][n+1];
		
		for(int i=0; i<=n; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=1; i<=k; i++) {
			for(int j=0; j<=n; j++) {
				for(int l=0; l<=j; l++) {
					dp[i][j] += dp[i-1][j-l] % 1000000000;
				}
			}
		}
		
		long answer = dp[k][n] % 1000000000;
		System.out.println(answer);
		
		br.close();
	}
}
