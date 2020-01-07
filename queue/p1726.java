package queue;

import java.awt.*;
import java.io.*;
import java.util.*;

public class p1726 {

	static Queue<ArrayList<Integer>> q;
	static int[][] map;
	static boolean[][][] isvisit;
	static int m, n;
	static int command;

	public static boolean isRange(int a, int b) {
		return (1 <= a && a <= m) && (1 <= b && b <= n);
	}

	public static void bfs(int sa, int sb, int sd, int ea, int eb, int ed) {
		int dy[] = { 0, 1, -1, 0, 0 };
		int dx[] = { 0, 0, 0, 1, -1 };

		ArrayList<Integer> point = new ArrayList<>();
		point.add(sa);
		point.add(sb);
		point.add(sd);
		point.add(0);

		q.offer(point);
		isvisit[sd][sa][sb] = true;

		while (!q.isEmpty()) {
			int x = q.peek().get(0);
			int y = q.peek().get(1);
			int z = q.peek().get(2);
			int comm = q.peek().get(3);
			//System.out.println("x : " + x + " y : " + y + " z : " + z + " comm : " + comm);
			q.poll();

			if (x == ea && y == eb && z == ed) {
				System.out.println(comm);
				break;
			}

			for (int i = 1; i <= 3; i++) {
				int nx = x + dx[z] * i;
				int ny = y + dy[z] * i;

				if (isRange(nx, ny) && map[nx][ny] == 0) {
					if(!isvisit[z][nx][ny]) {
						isvisit[z][nx][ny] = true;
						ArrayList<Integer> npoint = new ArrayList<>();
						npoint.add(nx);
						npoint.add(ny);
						npoint.add(z);
						npoint.add(comm+1);
						q.offer(npoint);
					}
				} else {
					break;
				}

			}

			for (int i = 1; i <= 4; i++) {
				if (z != i && !isvisit[i][x][y]) {
					isvisit[i][x][y] = true;
					ArrayList<Integer> npoint = new ArrayList<>();
					npoint.add(x);
					npoint.add(y);
					npoint.add(i);
					int t= comm+ turn(z,i);
					npoint.add(t);
					q.offer(npoint);
				}
			}

		}

	}

	public static int turn(int cur, int target) {
		if (cur == target) {
			return 0;
		}
		switch (cur) {
		case 1:
			if (target == 2)
				return 2;
			break;
		case 2:
			if (target == 1)
				return 2;
			break;
		case 3:
			if (target == 4)
				return 2;
			break;
		case 4:
			if (target == 3)
				return 2;
			break;
		}
		return 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m+1][n+1];
		isvisit = new boolean[5][m+1][n+1];
		q = new LinkedList<>();

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int sa = Integer.parseInt(st.nextToken());
		int sb = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int ea = Integer.parseInt(st.nextToken());
		int eb = Integer.parseInt(st.nextToken());
		int ed = Integer.parseInt(st.nextToken());

		bfs(sa, sb, sd, ea, eb, ed);

		br.close();
	}
}
