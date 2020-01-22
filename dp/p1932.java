package dp;

import java.util.*;
import java.io.*;

public class p1932 {
	
	static int n;
	public static boolean isRange(int a ,int b) {
		return(1<= a && a<=n) && (1<=b && b<=n);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			if(i==1) {
				triangle[1][1] = Integer.parseInt(br.readLine());
			}else {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=i; j++) {
					triangle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int[] dx = {-1,-1};
		int[] dy = {-1, 0};
		
		for(int i=1; i<=n; i++) {
			if(i==1) {
				dp[1][1] = triangle[1][1];
				continue;
			}else {
				for(int j=1; j<=i; j++) {
					for(int k=0; k<2; k++) {
						int bx = i + dx[k];
						int by = j + dy[k];
						if(isRange(bx,by)) {
							dp[i][j] = Math.max(dp[bx][by] + triangle[i][j], dp[i][j]);
						}
					}
				}
			}
		}
		
		int max = 0;
		
		for(int i=1; i<=n; i++) {
			if(max < dp[n][i]) {
				max = dp[n][i];
			}
		}
		System.out.println(max);
		
		
		br.close();
	}
}
