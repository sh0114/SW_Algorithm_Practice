package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p2146 {
	
	static class bridge{
		Point p;
		int cnt;
		
		bridge(Point p, int c){
			this.p = p;
			this.cnt = c;
		}
	}

	static int[][] map;
	static boolean[][] isvisit;
	static int n, min;

	public static boolean isRange(int a, int b) {
		return (0 <= a && a < n) && (0 <= b && b < n);
	}

	public static void bfs(int a, int b, int t) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a, b));
		isvisit[a][b] = true;
		map[a][b] = t;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (isRange(nx, ny) && !isvisit[nx][ny] && map[nx][ny] == 1) {
					map[nx][ny] = t;
					isvisit[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
	
	public static void make_bridge(int a, int b, int inum) {
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<bridge> q = new LinkedList<>();
		q.offer(new bridge(new Point(a,b), 0));
		
		while(!q.isEmpty()) {
			int x = q.peek().p.x;
			int y = q.peek().p.y;
			int c = q.peek().cnt;
			q.poll();
			
			if(map[x][y] > 1 && map[x][y] != inum) {
				if(c-1 < min) {
					min = c-1;
				}
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isRange(nx,ny) && !isvisit[nx][ny] && map[nx][ny] != inum) {
					q.offer(new bridge(new Point(nx,ny), c+1));
					isvisit[nx][ny] = true;
				}
			}
		}
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		isvisit = new boolean[n][n];
		min = 999999;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int target = 2;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, target);
					target++;
				}
			}
		}


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > 1) {
					isvisit = new boolean[n][n];
					make_bridge(i,j,map[i][j]);
				}
			}
		}

		System.out.println(min);

		br.close();
	}
}
