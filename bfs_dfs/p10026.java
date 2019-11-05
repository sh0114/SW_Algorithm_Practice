package bfs;

import java.io.*;
import java.awt.*;
import java.util.*;

public class p10026 {

	static char[][] map;
	static char[][] cbmap;
	static int n;
	static int cb_rg;
	static int red, green, blue;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static boolean isRange(int a, int b) {
		return (0 <= a && a < n) && (0 <= b && b < n);
	}

	public static void red(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a, b));
		map[a][b] = '#';
		
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				if(isRange(ax, ay)) {
					if(map[ax][ay] == 'R') {
						q.offer(new Point(ax,ay));
						map[ax][ay] = '#';
					}
				}
			}
		}
	}

	public static void green(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a, b));
		map[a][b] = '#';
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				if(isRange(ax, ay)) {
					if(map[ax][ay] == 'G') {
						q.offer(new Point(ax,ay));
						map[ax][ay] = '#';
					}
				}
			}
		}
	}

	public static void blue(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a, b));
		map[a][b] = '#';
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				if(isRange(ax, ay)) {
					if(map[ax][ay] == 'B') {
						q.offer(new Point(ax,ay));
						map[ax][ay] = '#';
					}
				}
			}
		}
	}
	
	public static void cbred(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a, b));
		map[a][b] = '#';
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				if(isRange(ax, ay)) {
					if(cbmap[ax][ay] == 'R') {
						q.offer(new Point(ax,ay));
						cbmap[ax][ay] = '#';
					}
				}
			}
		}
	}
	
//	public static void mapprint() {
//		System.out.println("====map===");
//		for(int i=0; i<n; i++) {
//			System.out.println(map[i]);
//		}
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cb_rg = 0;
		red = 0;
		green = 0;
		blue = 0;
		map = new char[n][n];
		cbmap = new char[n][n];

		for (int i = 0; i < n; i++) {
			String w = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = w.charAt(j);
				cbmap[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 'R') {
					red(i,j);
					red++;
				}

			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 'G') {
					green(i,j);
					green++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 'B') {
					blue(i,j);
					blue++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(cbmap[i][j] == 'G') {
					cbmap[i][j] = 'R';
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(cbmap[i][j] == 'R') {
					cbred(i,j);
					cb_rg++;
				}
			}
		}
		
		int sum = red+green+blue;
		int cbsum = cb_rg+blue;
		
		System.out.println(sum + " " + cbsum);

		br.close();
	}
}
