package dp;

import java.util.*;
import java.io.*;

public class p2229 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n+1];
		long[] dp = new long[n+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			long max = 0;
			long min = 99999;
			score[i] = Integer.parseInt(st.nextToken());
			
			for(int j=i; j>=1; j--) {
				max = Math.max(max, score[j]);
				min = Math.min(min, score[j]);
				dp[i] = Math.max(dp[i], max-min + dp[j-1]);
			}
		}
		
		for(int i=1; i<=n;i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		
		
		br.close();
	}
}
