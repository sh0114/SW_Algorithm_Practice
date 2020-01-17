package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p6593 {
	
	static class sangbom {
		int f;
		int x;
		int y;
		int time;
		
		sangbom(int f, int x, int y, int t){
			this.f = f;
			this.x = x;
			this.y = y;
			this.time = t;
		}
	}
	
	static boolean[][][] isvisit;
	static char[][][] building;
	static int l,r,c, answer;
	
	public static boolean isRange(int f, int a, int b) {
		return (0<= f && f<l ) && (0<=a && a<r) && (0<=b && b<c);
	}
	
	public static void bfs(int f, int a, int b) {
		int[] df = {1,-1,0,0,0,0};
		int[] dx = {0,0,1,-1,0,0};
		int[] dy = {0,0,0,0,1,-1};
		
		Queue<sangbom> q = new LinkedList<>();
		q.offer(new sangbom(f,a,b,0));
		isvisit[f][a][b] = true;
		
		while(!q.isEmpty()) {
			int cf = q.peek().f;
			int cx = q.peek().x;
			int cy = q.peek().y;
			int ct = q.peek().time;
			q.poll();
			
			if(building[cf][cx][cy] == 'E') {
				answer = ct;
				break;
			}
			
			for(int i=0; i<6; i++) {
				int nf = cf + df[i];
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(isRange(nf,nx,ny) && !isvisit[nf][nx][ny] && building[nf][nx][ny] != '#') {
					q.offer(new sangbom(nf,nx,ny,ct+1));
					isvisit[nf][nx][ny] = true;
				}
				
			}
		}
		
		
	}
	
	public static void print() {
		for(int k=0; k<l; k++) {
			System.out.println("-----------");
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					System.out.print(building[k][i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(l == 0 && r == 0 && c == 0) {
				break;
			}
			
			building = new char[l][r][c];
			isvisit = new boolean[l][r][c];
			answer = -1;
			
			int sf=0, sx=0, sy=0;
			
			for(int k=0; k<l; k++) {
				for(int i=0; i<r; i++) {
					String s = br.readLine();
					for(int j=0; j<c; j++) {
						building[k][i][j] = s.charAt(j);
						if(building[k][i][j] == 'S') {
							sf = k;
							sx = i;
							sy = j;
						}
					}
				}
				br.readLine();
			}
			
			bfs(sf,sx,sy);
			
			if(answer<0) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in "+ answer+" minute(s).");
			}
			
		}
		
		br.close();
	}
}
