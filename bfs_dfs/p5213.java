package bfsdfs;

import java.util.*;
import java.io.*;

public class p5213 {

	static class tile {
		int x;
		int y;
		int l;
		int r;
		int num;

		tile(int x, int y, int l, int r, int num) {
			this.x = x;
			this.y = y;
			this.l = l;
			this.r = r;
			this.num = num;
		}
	}

	static boolean[][][] adj;
	static boolean[][] isvisit;
	static int[] path;
	static tile[][] map;
	static int n, maxtile;

	public static boolean isRange(int a, int b) {
		if (a % 2 == 1)
			return (0 <= a && a < n) && (0 <= b && b < n - 1);
		return (0 <= a && a < n) && (0 <= b && b < n);
	}

	public static void bfs() {
		int[] odx = { -1, 0, 1, -1, 0, 1 };
		int[] ody = { -1, -1, -1, 0, 1, 0 };
		
		int[] edx = { -1, 0, 1, -1, 0, 1 };
		int[] edy = { 0, -1, 0, 1, 1, 1 };

		Queue<tile> q = new LinkedList<>();
		q.offer(map[0][0]);
		isvisit[0][0] = true;

		maxtile = 0;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int l = q.peek().l;
			int r = q.peek().r;
			int num = q.peek().num;
			q.poll();

			// System.out.println("x : " + x + " y : " + y + " l : " + l + " r : " + r + "
			// num : " + num);
			
			maxtile = Math.max(maxtile, num);
			
			int last = (n * n) - (n/2);

			if (maxtile == last) {
				break;
			}

			if (x % 2 == 0) {
				for (int i = 0; i < 3; i++) {
					int nx = x + odx[i];
					int ny = y + ody[i];

					if (isRange(nx, ny) && !isvisit[nx][ny]) {
						if (map[nx][ny].r == l) {
							isvisit[nx][ny] = true;
							q.offer(map[nx][ny]);
							path[map[nx][ny].num] = num;
						}
					}
				}
				for (int i = 3; i < 6; i++) {
					int nx = x + odx[i];
					int ny = y + ody[i];

					if (isRange(nx, ny) && !isvisit[nx][ny]) {
						if (map[nx][ny].l == r) {
							isvisit[nx][ny] = true;
							q.offer(map[nx][ny]);
							path[map[nx][ny].num] = num;
						}
					}
				}
			} else {
				for (int i = 0; i < 3; i++) {
					int nx = x + edx[i];
					int ny = y + edy[i];

					if (isRange(nx, ny) && !isvisit[nx][ny]) {
						if (map[nx][ny].r == l) {
							isvisit[nx][ny] = true;
							q.offer(map[nx][ny]);
							path[map[nx][ny].num] = num;
						}
					}
				}
				for (int i = 3; i < 6; i++) {
					int nx = x + edx[i];
					int ny = y + edy[i];

					if (isRange(nx, ny) && !isvisit[nx][ny]) {
						if (map[nx][ny].l == r) {
							isvisit[nx][ny] = true;
							q.offer(map[nx][ny]);
							path[map[nx][ny].num] = num;
						}
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new tile[n][n];
		isvisit = new boolean[n][n];
		path = new int[n * n];

		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 1 && j == n - 1)
					continue;
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[i][j] = new tile(i, j, a, b, num);
				num++;
			}
		}

		bfs();

		ArrayList<Integer> answer = new ArrayList<>();
		int chk = path[maxtile];
		answer.add(maxtile);

		while (true) {
			if (chk == 1) {
				answer.add(chk);
				break;
			}
			for (int i = 0; i < n * n; i++) {
				if (chk == i) {
					answer.add(i);
					chk = path[i];
					break;
				}
			}

		}

		System.out.println(answer.size());
		for (int i = answer.size() - 1; i >= 0; i--) {
			System.out.print(answer.get(i) + " ");
		}
		System.out.println();
		br.close();
	}
}
