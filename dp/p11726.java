package dp;
import java.util.*;
public class p11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		if(n==1) {
			dp[1] = 1;
		}else if(n==2) {
			dp[2] = 2;
		}else {
			dp[1] = 1;
			dp[2] = 2;
			for(int i=3; i<=n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 10007;
			}
		}
		
		System.out.println(dp[n]%10007);
		
		sc.close();
	}
}
