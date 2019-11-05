package dfs;

import java.util.*;
import java.awt.*;
public class p1012 {
	
	static int m,n,k;
	static int[][] baechu;
	
	public static boolean isRange(int a, int b) {
		return (0<=a && a<m)&&(0<=b&&b<n);
	}
	
	public static void bfs(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a,b));
		
		int[] dx = {1,-1,0,0}, dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int x = q.peek().x; 
			int y = q.poll().y;
			
			for(int i=0; i<4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				if(isRange(ax,ay)) {
					if(baechu[ax][ay] == 1) {
						q.offer(new Point(ax,ay));
						baechu[ax][ay] = 0;
					}
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			
			baechu = new int[m][n];
			
			for(int i=0; i<k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				baechu[a][b] = 1;
			}
			int count = 0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(baechu[i][j] == 1) {
						bfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

		sc.close();
	}
}
