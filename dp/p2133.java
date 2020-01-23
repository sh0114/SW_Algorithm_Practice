package dp;

import java.io.*;

public class p2133 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		int answer = 0;
		
		if(n%2 == 0) {
			dp[2] = 3;
			dp[0] = 1;
			for(int i=4; i<=n; i += 2) {
				dp[i] += dp[i-2]*3;
				for(int j=4; j<=i; j+=2) {
					dp[i] += dp[i-j]*2;
				}
			}
			answer = dp[n];
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
