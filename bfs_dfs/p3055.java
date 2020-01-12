package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p3055 {

	static char[][] forest;
	static Queue<Point> hedgehog;
	static Queue<Point> water;
	static int r, c, answer;

	public static boolean isRange(int a, int b) {
		return (0 <= a && a < r) && (0 <= b && b < c);
	}

	public static void bfs() {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		int count = 0;
		
		while (!hedgehog.isEmpty()) {
			count++;
			
			int wsize = water.size();

			for (int k = 0; k < wsize; k++) {
				int x = water.peek().x;
				int y = water.poll().y;
				
				for (int i = 0; i < 4; i++) {
					int a = x + dx[i];
					int b = y + dy[i];
					if (isRange(a, b) && forest[a][b] == '.') {
						forest[a][b] = '*';
						water.offer(new Point(a,b));
					}
				}
			}
			
			int hsize = hedgehog.size();
			
			for(int k=0; k<hsize; k++) {
				int x = hedgehog.peek().x;
				int y = hedgehog.poll().y;

				for (int i = 0; i < 4; i++) {
					int ax = x + dx[i];
					int ay = y + dy[i];

					if (isRange(ax, ay)) {
						if(forest[ax][ay] == '.') {
							forest[ax][ay] = 'S';
							hedgehog.offer(new Point(ax, ay));
						}else if(forest[ax][ay] == 'D') {
							answer = count;
							return;
						}
					}
				}
			}
			
		}
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		forest = new char[r][c];
		water = new LinkedList<>();
		hedgehog = new LinkedList<>();
		answer = -1;


		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				forest[i][j] = s.charAt(j);
				if (forest[i][j] == 'S') {
					hedgehog.offer(new Point(i, j));
				}else if (forest[i][j] == '*') {
					water.offer(new Point(i, j));
				}
			}
		}

		bfs();

		if (answer < 0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(answer);
		}

		br.close();
	}
}
