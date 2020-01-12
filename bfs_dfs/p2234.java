package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p2234 {

	static boolean[][] isvisit;
	static int[][] castle;
	static Point[][] map;
	static int n, m, rooms, max, dmax;

	public static boolean isRange(int a, int b) {
		return (0 <= a && a < n) && (0 <= b && b < m);
	}

	public static void bfs(int a, int b) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> parr = new ArrayList<>();
		q.offer(new Point(a, b));
		parr.add(new Point(a, b));
		isvisit[a][b] = true;

		int count = 0;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			count++;

			String bin = Integer.toBinaryString(castle[x][y]);
			if (bin.length() < 4) {
				while (bin.length() < 4) {
					bin = "0" + bin;
				}
			}
			for (int i = 0; i < 4; i++) {
				String chk = bin.substring(i, i + 1);
				if (chk.equals("0")) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (isRange(nx, ny) && !isvisit[nx][ny]) {
						q.offer(new Point(nx, ny));
						parr.add(new Point(nx, ny));
						isvisit[nx][ny] = true;
					}
				}
			}

		}
		rooms++;
		for (int i = 0; i < parr.size(); i++) {
			int px = parr.get(i).x;
			int py = parr.get(i).y;
			map[px][py] = new Point(rooms, count);
		}
		if (max < count) {
			max = count;
		}

	}

	public static void deletewall(int a, int b) {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a,b));
		isvisit[a][b] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			
			q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(isRange(nx,ny) && !isvisit[nx][ny]) {
					if(map[nx][ny].x != map[a][b].x) {
						dmax = Math.max(dmax, map[nx][ny].y + map[a][b].y);
					}else {
						q.offer(new Point(nx,ny));
						isvisit[nx][ny] = true;
					}
				}
				
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		castle = new int[n][m];
		map = new Point[n][m];
		isvisit = new boolean[n][m];

		rooms = 0;
		max = 0;
		dmax = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!isvisit[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		isvisit = new boolean[n][m];
		
		if(rooms == m*n) {
			dmax = 2;
		}else {
			for(int k=1; k<=rooms; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if(map[i][j].x == k && !isvisit[i][j])
							deletewall(i,j);
					}
				}
			}
		}

		System.out.println(rooms);
		System.out.println(max);
		System.out.println(dmax);

		br.close();
	}
}
