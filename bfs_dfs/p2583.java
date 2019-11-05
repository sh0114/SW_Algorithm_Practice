package bfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p2583 {
	static int m, n, k;
	static int[][] map;
	static int[][] square;
	static Stack<Integer> s;

	public static boolean isRange(int a, int b) {
		return (0 <= a && a < m) && (0 <= b && b < n);
	}

	public static void bfs(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		int[] dx = {1,-1,0,0}, dy = {0,0,-1,1};
		
		q.offer(new Point(a,b));
		map[a][b] = 1;
		
		int temp = 1;
		
		while(!q.isEmpty()) {
			int x = q.peek().x; int y = q.poll().y;
			for(int i=0; i<4; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				if(isRange(ax,ay)) {
					if(map[ax][ay] == 0) {
						q.offer(new Point(ax,ay));
						map[ax][ay] = 1;
						temp++;
					}
				}
			}
		}
		
		s.push(temp);
	}
	
//	public static void mapprint() {
//		System.out.println("---map---");
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new int[m][n];
		square = new int[k][4];
		s = new Stack<>();

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < k; i++) {
			int dy = Math.abs(square[i][0] - square[i][2]);
			int dx = Math.abs(square[i][1] - square[i][3]);

			int cx = square[i][1];
			int cy = square[i][0];
			for (int a = 0; a < dx; a++) {
				for (int b = 0; b < dy; b++) {
					map[cx + a][cy + b] = 1;
				}
			}
		}
		
		
		int cnt = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		
		int[] arr = new int[s.size()];
		for(int i=0; i<s.size(); i++) {
			arr[i] = s.get(i);
		}
		
		Arrays.sort(arr);
		
		System.out.println(cnt);
		
		for(int i=0; i<s.size(); i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		br.close();
	}
}
