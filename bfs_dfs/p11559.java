package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p11559 {

	static boolean isfinish;
	static char[][] puyo;
	static int n, m, payoen;

	public static boolean isRange(int a, int b) {
		return (0 <= a && a < n) && (0 <= b && b < m);
	}

	public static void bfs(int a, int b, char target) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		boolean[][] isvisit = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> payoenarr = new ArrayList<>();
		q.offer(new Point(a, b));
		payoenarr.add(new Point(a, b));
		
		isvisit[a][b] = true;
		
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isRange(nx, ny) && !isvisit[nx][ny] && puyo[nx][ny] == target) {
					isvisit[nx][ny] = true;
					q.offer(new Point(nx, ny));
					payoenarr.add(new Point(nx,ny));
				}
			}
		}

		int len = payoenarr.size();
		if (len >= 4) {
			isfinish = false;
			
			for (int i = 0; i < len; i++) {
				int px = payoenarr.get(i).x;
				int py = payoenarr.get(i).y;
				puyo[px][py] = '.';
			}
		}

	}

	public static void down() {
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (puyo[i][j] != '.') {
					int nx = i;
					char temp = puyo[i][j];
					puyo[i][j] = '.';

					while (true) {
						if (!isRange(nx + 1, j) || puyo[nx + 1][j] != '.')
							break;
						nx++;
					}
					puyo[nx][j] = temp;
				}
			}
		}
	}

//	public static void puyopuyo() {
//		System.out.println("»Ñ¿ä»Ñ¿ä : ºü¿ä¿£~~");
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(puyo[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = 12;
		m = 6;
		payoen = 0;
		isfinish = false;
		puyo = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				puyo[i][j] = s.charAt(j);
			}
		}


		while (!isfinish) {
			isfinish = true;
			down();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (puyo[i][j] != '.') {
						bfs(i, j, puyo[i][j]);
					}
				}
			}
			if(!isfinish) {
				payoen++;
			}
			// puyopuyo();

		}

		System.out.println(payoen);

		br.close();
	}
}
