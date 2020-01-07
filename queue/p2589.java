package queue;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p2589 {
	
	static int[][] map;
	static boolean[][] isvisit;
	static Queue<Point> q;
	static int m, n , maxdist;
	
	public static boolean isRange(int a, int b) {
		return (0<=a && a<m) && (0<=b && b<n);
	}
	
	public static void bfs(int a, int b) {
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		
		q.offer(new Point(a,b));
		isvisit[a][b] = true;
		
		int hours = 1;
		int count = 0;
		int thours = 0;
		int dist = 0;
		
		while(!q.isEmpty()) {
			if(hours == count) {
				hours = thours;
				thours = 0;
				count = 0;
				dist++;
			}
			
			int x = q.peek().x;
			int y = q.poll().y;
			
			for(int i=0; i<4; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				
				if(isRange(ax,ay) && !isvisit[ax][ay] && map[ax][ay] == 1) {
					isvisit[ax][ay] = true;
					q.offer(new Point(ax,ay));
					thours++;
				}
			}
			count++;

		}

		if(dist > maxdist) {
			maxdist = dist;
		}
		
		init_isvisit();
	}
	
	public static void init_isvisit() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				isvisit[i][j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		isvisit = new boolean[m][n];
		q = new LinkedList<>();
		maxdist = 0;
		
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				if(s.substring(j,j+1).equals("L"))
					map[i][j] = 1;
				else
					map[i][j] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
		System.out.println(maxdist);
		br.close();
	}
}
