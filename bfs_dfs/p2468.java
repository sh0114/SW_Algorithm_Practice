package dfs;
import java.util.*;
import java.io.*;
import java.awt.*;

public class p2468 {
	static int n;
	static int[][] area;
	static boolean[][] isvisit;
	
	public static boolean isRange(int a, int b) {
		return(0<=a && a<n) && (0<=b && b<n);
	}
	
	public static void bfs(int a, int b, int h) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a,b));
		int[] dx = {1,-1,0,0}, dy= {0,0,-1,1};
		isvisit[a][b] = true;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for(int i=0; i<4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				
				if(isRange(ax,ay)) {
					if(area[ax][ay] > h && !isvisit[ax][ay]) {
						q.offer(new Point(ax,ay));
						isvisit[ax][ay] = true;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		area = new int[n][n];
		isvisit = new boolean[n][n];
		
		int hmin = 999; int hmax = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] < hmin) {
					hmin = area[i][j];
				}
				if(area[i][j] > hmax) {
					hmax = area[i][j];
				}
			}
		}
		int res = 0;
		for(int h = hmin-1; h <= hmax; h++) {
			int count = 0;
			isvisit = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(area[i][j] > h && !isvisit[i][j]) {
						bfs(i,j,h);
						count++;
					}
				}
			}
			

			if(count > res) {
				res = count;
			}
		}
		System.out.println(res);
		br.close();
	}
}
