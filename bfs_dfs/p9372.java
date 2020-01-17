package bfs_dfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p9372 {
	static boolean[] isvisit;
	static int[][] flight;
	static int n,m, count;
	
	public static boolean isRange(int a, int b) {
		return (0<=a && a<=n) && (0<=b && b<=n);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		isvisit[1] = true;

		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(flight[x][i] == 1 && !isvisit[i]) {
					q.offer(i);
					isvisit[i] = true;
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			flight = new int[n+1][n+1];
			isvisit = new boolean[n+1];
			count = 0;
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				flight[a][b] = 1;
				flight[b][a] = 1;
			}
			
			bfs();
			
			System.out.println(count);
		}
		
		br.close();
	}
}
