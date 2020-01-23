package dp;

import java.util.*;
import java.io.*;

public class p11060 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] maze = new int[n+1];
		long[] dp = new long[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			maze[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			dp[i] = -1;
		}
		
		dp[1] = 0;
		
		for(int i=1; i<n; i++) {
			if(dp[i] == -1) {
				continue;
			}
			for(int j=i+1; j<=i+maze[i]; j++) {
				if(j>n) break;
				if(dp[j] == -1 || dp[j]>dp[i]+1) {
					dp[j] = dp[i] + 1;
				}
			}
		}
		
		System.out.println(dp[n]);
		
		br.close();
	}
}
