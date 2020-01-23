package dp;

import java.util.*;
import java.io.*;

public class p2096 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] game = new int[n+1][3];
		long[][] maxdp = new long[n+1][3];
		long[][] mindp = new long[n+1][3];
		
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxdp[1][0] = game[1][0];
		maxdp[1][1] = game[1][1];
		maxdp[1][2] = game[1][2];
		
		mindp[1][0] = game[1][0];
		mindp[1][1] = game[1][1];
		mindp[1][2] = game[1][2];
		
		
		if(n>1) {
			for(int i=2; i<=n; i++) {
				maxdp[i][0] = Math.max(maxdp[i-1][0] + game[i][0], maxdp[i-1][1] + game[i][0]);
				maxdp[i][1] = Math.max(maxdp[i-1][0] + game[i][1], maxdp[i-1][1] + game[i][1]);
				maxdp[i][1] = Math.max(maxdp[i][1], maxdp[i-1][2] + game[i][1]);
				maxdp[i][2] = Math.max(maxdp[i-1][2] + game[i][2], maxdp[i-1][1] + game[i][2]);
			}
			
			for(int i=2; i<=n; i++) {
				mindp[i][0] = Math.min(mindp[i-1][0] + game[i][0], mindp[i-1][1] + game[i][0]);
				mindp[i][1] = Math.min(mindp[i-1][0] + game[i][1], mindp[i-1][1] + game[i][1]);
				mindp[i][1] = Math.min(mindp[i][1], mindp[i-1][2] + game[i][1]);
				mindp[i][2] = Math.min(mindp[i-1][2] + game[i][2], mindp[i-1][1] + game[i][2]);
			}
			
		}
		
		long max = Math.max(maxdp[n][2], Math.max(maxdp[n][0], maxdp[n][1]));
		long min = Math.min(mindp[n][2], Math.min(mindp[n][0], mindp[n][1]));
		
		System.out.println(max + " " + min);
		
		br.close();
	}
}
