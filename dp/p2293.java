package dp;
import java.util.*;
import java.io.*;
public class p2293 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		for(int i=1; coin[0]*i <= k;i++) {
			dp[coin[0]*i] = 1;
		}
		

		for(int i=1; i<n; i++) {
			for(int j= coin[i]; j<=k; j++) {
				dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[k]);
		br.close();
	}
}
