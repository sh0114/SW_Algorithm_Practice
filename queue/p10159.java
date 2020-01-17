package queue;

import java.util.*;
import java.io.*;

public class p10159 {

	static int[][] stuff;
	static int n, m;

	public static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (stuff[i][k] == 1 && stuff[k][j] == 1) {
						stuff[i][j] = 1;
					}
					if (stuff[i][k] == -1 && stuff[k][j] == -1) {
						stuff[i][j] = -1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		stuff = new int[n + 1][n + 1];

		for (int i = 0; i <m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			stuff[a][b] = 1;
			stuff[b][a] = -1;

		}
		floyd();

		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if(i==j) continue;
				if (stuff[i][j] == 0)
					count++;
			}
			System.out.println(count);
		}
		br.close();
	}
}
