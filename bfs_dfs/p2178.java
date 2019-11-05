package bfs;
import java.util.*;
import java.io.*;
import java.awt.*;
public class p2178 {
	
	static int n, m;
	static int result;
	static int[][] map;
	
	public static boolean isRange(int x, int y) {
		return (0<= x && x <n) && (0<= y && y<m);
	}
	
	public static void bfs(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a,b));
		int[] dx = {1,-1,0,0}, dy = {0,0,-1,1};
		
		int ntcnt = 0;
		int curcnt = 1;
		
		boolean chk = false;
		while(!q.isEmpty()) {
			int x = q.peek().x; 
			int y = q.poll().y;
			
			if(curcnt == 0) {
				curcnt = ntcnt;
				ntcnt = 0;
				result++;
			}
			
			for(int i=0; i<4; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				
				if(isRange(ax, ay)) {
					if(ax == n-1 && ay == m-1) {
						chk = true;
						result++;
						break;
					}
					
					if(map[ax][ay] == 1) {
						q.offer(new Point(ax,ay));
						map[ax][ay] = 0;
						ntcnt++;
					}
					
				}
			}
			if(chk) {
				break;
			}
			curcnt--;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		result = 1;
		
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(s.substring(j,j+1));
			}
		}
		
		bfs(0,0);
		System.out.println(result);
		
		br.close();
	}
}
