package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p2573 {
	
	static Queue<Point> ice;
	static boolean[][] isvisit;
	static int[][] arctic;
	static int[][] temp;
	static int n, m, answer;
	
	public static boolean isRange(int a, int b) {
		return (0<= a && a<n) && (0<=b && b<m);
	}
	
	public static void copyice() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arctic[i][j] = temp[i][j];
			}
		}
	}
	
	public static void bfs() {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int count = 0;
		
		while(!ice.isEmpty()) {
			
			int ic = ice.size();
			count++;
			
			while(ic-->0) {
				int x = ice.peek().x;
				int y = ice.poll().y;
				
				int zero = 0;
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(isRange(nx,ny) && arctic[nx][ny] == 0)
						zero++;
				}
				
				if(arctic[x][y] - zero > 0) {
					temp[x][y] = arctic[x][y] - zero;
					ice.offer(new Point(x,y));
				}
				else {
					temp[x][y] = 0;
				}
			}
			
			copyice();
			//print();
			if(icechk()) {
				answer = count;
				break;
			}
			
		}
		
	}
	
	public static boolean icechk() {
		int cnt =0;
		isvisit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arctic[i][j] >0 && !isvisit[i][j]) {
					icebfs(i,j);
					cnt++;
				}
			}
		}
		if(cnt >= 2) {
			return true;
		}
		return false;
	}
	
	public static void icebfs(int a, int b) {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a,b));
		isvisit[a][b] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(isRange(nx,ny) && !isvisit[nx][ny] && arctic[nx][ny] >0) {
					isvisit[nx][ny] = true;
					q.offer(new Point(nx,ny));
				}
			}
		}
	}
	
	public static void print() {
		System.out.println("---ºÏ±Ø---");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arctic[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arctic = new int[n][m];
		temp = new int[n][m];
		ice = new LinkedList<>();
		answer = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arctic[i][j] = Integer.parseInt(st.nextToken());
				if(arctic[i][j] > 0)
					ice.offer(new Point(i,j));
			}
		}
		
		bfs();
		
		System.out.println(answer);
		
		br.close();
	}
}
