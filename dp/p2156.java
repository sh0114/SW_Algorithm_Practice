package dp;

import java.io.*;

public class p2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[] podo = new long[n + 1];
		long[] dp = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			podo[i] = Long.parseLong(br.readLine());
		}

		dp[1] = podo[1];
		if (n > 1) {
			dp[2] = podo[1] + podo[2];
			for (int i = 3; i <= n; i++) {
				dp[i] = Math.max(dp[i - 2] + podo[i], dp[i - 3] + podo[i - 1] + podo[i]);
				dp[i] = Math.max(dp[i - 1], dp[i]);
			}
		}

		System.out.println(dp[n]);

		br.close();
	}
}
