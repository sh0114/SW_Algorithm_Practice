package bfsdfs;

import java.util.*;
import java.io.*;

public class p1600 {
	
	static class monkey{
		int x;
		int y;
		int cnt;
		int kcnt;
		
		public monkey(int x, int y, int c, int kc) {
			this.x = x;
			this.y = y;
			this.cnt = c;
			this.kcnt = kc;
		}
	}
	
	static Queue<monkey> q;
	static boolean[][][] isvisit;
	static int[][] map;
	static int k,w,h;
	static int min;
	
	public static boolean isRange(int a, int b) {
		return (0<=a && a<h) && (0<=b && b<w);
	}
	
	public static void bfs(int a, int b, int c) {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int[] hx = {-1,1,-2,2,-2,2,-1,1};
		int[] hy = {-2,-2,-1,-1,1,1,2,2};
		
		q.offer(new monkey(a,b,c,k));
		isvisit[k][a][b] = true;
		
		while(!q.isEmpty()) {
			int curx = q.peek().x;
			int cury = q.peek().y;
			int curcnt = q.peek().cnt;
			int curkcnt = q.peek().kcnt;
			q.poll();
			
			if(curx == h-1 && cury == w-1) {
				min = curcnt;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int ax = curx + dx[i];
				int ay = cury + dy[i];
				
				if(isRange(ax,ay) && !isvisit[curkcnt][ax][ay] && map[ax][ay] == 0) {
					q.offer(new monkey(ax,ay,curcnt+1,curkcnt));
					isvisit[curkcnt][ax][ay] = true;
				}
			}
			
			if(curkcnt > 0) {
				for(int i=0; i<8; i++) {
					int ax = curx + hx[i];
					int ay = cury + hy[i];
					
					if(isRange(ax,ay) && !isvisit[curkcnt-1][ax][ay] && map[ax][ay] == 0) {
						q.offer(new monkey(ax,ay,curcnt+1,curkcnt-1));
						isvisit[curkcnt-1][ax][ay] = true;
					}
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		isvisit = new boolean[k+1][h][w];
		q = new LinkedList<>();
		min = 0;
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0,0);
		
		if(min == 0) {
			min = -1;
		}
		System.out.println(min);
		
		br.close();
	}
}
