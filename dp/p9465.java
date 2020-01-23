package dp;

import java.util.*;
import java.io.*;

public class p9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[][] stiker = new int[2][n + 1];
			long[][] dp = new long[2][n + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					stiker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			long answer = 0;
			dp[0][1] = stiker[0][1];
			dp[1][1] = stiker[1][1];
			if (n == 1) {
				answer = Math.max(dp[0][1], dp[1][1]);
			} else {
				dp[0][2] = dp[1][1] + stiker[0][2];
				dp[1][2] = dp[0][1] + stiker[1][2];

				if (n == 2) {
					answer = Math.max(dp[0][2], dp[1][2]);
				} else {
					long max = 0;

					for (int i = 3; i <= n; i++) {
						dp[0][i] = Math.max(dp[1][i - 1] + stiker[0][i], dp[1][i - 2] + stiker[0][i]);
						dp[1][i] = Math.max(dp[0][i - 1] + stiker[1][i], dp[0][i - 2] + stiker[1][i]);
						if (max < dp[0][i]) {
							max = dp[0][i];
						}
						if (max < dp[1][i]) {
							max = dp[1][i];
						}
					}
					answer = max;
				}
				System.out.println(answer);
			}
		}

		br.close();
	}
}
