package dp;

import java.util.*;
import java.io.*;

public class p11052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = cards[1];
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + cards[j]);
			}
		}
		

		System.out.println(dp[n]);
		
		br.close();
	}
}
