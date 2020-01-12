package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p2206 {
	
	static class move{
		int x;
		int y;
		int wall;
		int dist;
		
		move(int x, int y, int w, int d){
			this.x = x;
			this.y = y;
			this.wall = w;
			this.dist = d;
		}
	}
	
	static boolean[][][] isvisit;
	static int[][] map;
	static int n,m, answer;
	
	public static boolean isRange(int a, int b) {
		return (0<=a && a<n) && (0<=b && b<m);
	}
	
	public static void bfs() {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<move> q = new LinkedList<>();
		q.offer(new move(0,0,0,1));
		isvisit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			
			int x = q.peek().x;
			int y = q.peek().y;
			int d = q.peek().dist;
			int w = q.peek().wall;
			q.poll();
			
			//System.out.println("x : " + x + " y : " + y + " dist: " + d + " wall : " + w);
			
			if(x == n-1 && y == m-1) {
				answer = d;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isRange(nx,ny) && !isvisit[w][nx][ny]) {
					if(map[nx][ny] == 1) {
						if(w==0) {
							q.offer(new move(nx,ny,1,d+1));
							isvisit[1][nx][ny] = true;
						}
					}else {
						q.offer(new move(nx,ny,w,d+1));
						isvisit[w][nx][ny] = true;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		isvisit = new boolean[2][n][m];
		answer = -1;
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(s.substring(j,j+1));
			}
		}
		
		bfs();
		
		System.out.println(answer);
		
		br.close();
	}
}
