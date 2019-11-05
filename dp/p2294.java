package dp;
import java.util.*;
import java.io.*;

public class p2294 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coin = new int[n];
		
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				if(j == coin[i]) {
					dp[j] = 1;
					continue;
				}
				if((dp[j] == 0 || dp[j]>= dp[j-coin[i]] + 1) && dp[j-coin[i]] != 0) {
					dp[j] = dp[j-coin[i]] + 1;
				}
			}
		}
		

		if(dp[k] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
		sc.close();
	}
}
