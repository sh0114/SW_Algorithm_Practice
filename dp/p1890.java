package dp;

import java.util.*;
import java.io.*;

public class p1890 {
	
	static int n;
	public static boolean isRange(int a) {
		return (1<=a && a<=n);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[][] game = new int[n+1][n+1];
		long[][] dp = new long[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dp[i][j] == 0 || (i==n && j==n)) 
					continue;
				else {
					int down = i + game[i][j];
					int right = j + game[i][j];
					
					if(isRange(down)) {
						dp[down][j] += dp[i][j];
					}
					
					if(isRange(right)) {
						dp[i][right] += dp[i][j];
					}
				}

			}
		}
		
		System.out.println(dp[n][n]);
		
		br.close();
	}
}
