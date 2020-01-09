package bfsdfs;

import java.util.*;
import java.io.*;

public class p10971 {
	
	static int[][] map;
	static boolean[] isvisit;
	static int n;
	static int min;
	
	public static void dfs(int start, int x, int sum, int count) {
		if(count == n && start == x) {
			min = sum;
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!isvisit[i] && map[x][i] != 0 && sum+map[x][i] < min) {
				isvisit[i] = true;
				dfs(start,i,sum+map[x][i], count + 1);
				isvisit[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		isvisit = new boolean[n+1];
		min = Integer.MAX_VALUE;
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n; i++) {
			dfs(i,i,0,0);
		}

		
		System.out.println(min);
		
		br.close();
	}
}
