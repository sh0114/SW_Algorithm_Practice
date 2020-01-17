package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p5427 {
	
	static Queue<Point> fire;
	static Queue<Point> sang;
	static char[][] map;
	static boolean[][] isvisit;
	static int w, h, answer;
	
	public static boolean isRange(int a, int b) {
		return(0<=a && a<h) && (0<=b && b<w);
	}
	
	public static void bfs() {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int count =0;
		while(!sang.isEmpty()) {
			
			int fc = fire.size();
			
			while(fc-->0) {
				int fx = fire.peek().x;
				int fy = fire.poll().y;
				
				for(int i=0; i<4; i++) {
					int nfx = fx + dx[i];
					int nfy = fy + dy[i];
					
					if(isRange(nfx, nfy) && map[nfx][nfy] == '.') {
						map[nfx][nfy] = '*';
						fire.offer(new Point(nfx,nfy));
					}
				}
			}
			
			int sc = sang.size();
			count++;
			
			boolean c = false;
			while(sc-->0) {
				int sx = sang.peek().x;
				int sy = sang.poll().y;
				isvisit[sx][sy] = true;
				
				for(int i=0; i<4; i++) {
					int nsx = sx + dx[i];
					int nsy = sy + dy[i];
					if(isRange(nsx, nsy)){
						if(!isvisit[nsx][nsy] && map[nsx][nsy] == '.') {
							sang.offer(new Point(nsx,nsy));
							isvisit[nsx][nsy] = true;
						}
					}else {
						c = true;
						break;
					}
				}
				if(c)
					break;
			}
			if(c) {
				answer = count;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			isvisit = new boolean[h][w];
			fire = new LinkedList<>();
			sang = new LinkedList<>();
			
			answer = -1;
			
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '@') 
						sang.offer(new Point(i,j));
					else if(map[i][j] == '*')
						fire.offer(new Point(i,j));
				}
			}
			
			bfs();
			
			if(answer <0) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(answer);
			}
		}
		
		br.close();
	}
}
