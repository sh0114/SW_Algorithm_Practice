package queue;

import java.util.*;
import java.awt.*;
import java.io.*;

public class p7579 {
	
	static int tomato[][][];
	static boolean isvisit[][][];
	static int m,n,h; // m = 열, n = 행, h = 높이
	static int days, tdays, answer;
	
	static Queue<ArrayList<Integer>> q;
	
	public static boolean isRange(int a, int b, int c) {
		return(0<=a && a<n) && (0<=b && b<m) && (0<=c && c<h);
	}
	
	public static void bfs() {
		int[] dx = {1,-1,0,0,0,0};
		int[] dy = {0,0,1,-1,0,0};
		int[] dz = {0,0,0,0,1,-1};
		
		days = q.size();
		int count = 0;
		while(!q.isEmpty()) {
			if(days == count) {
				days = tdays;
				tdays = 0;
				count = 0;
				answer++;
			}
			int x = q.peek().get(0);
			int y = q.peek().get(1);
			int z = q.poll().get(2);
			
			for(int i=0; i<6; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				int az = z+dz[i];
				
				if(isRange(ax,ay,az) && !isvisit[az][ax][ay] && tomato[az][ax][ay] != -1) {
					tomato[az][ax][ay] = 1;
					ArrayList<Integer> apoint = new ArrayList<>();
					apoint.add(ax);
					apoint.add(ay);
					apoint.add(az);
					isvisit[az][ax][ay] = true;
					q.offer(apoint);
					tdays++;
				}
				
			}
			count++;
		}
	}
	
	public static boolean checkfunc() {
		boolean chk = true;
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					//System.out.print(tomato[k][i][j] + " ");
					if(tomato[k][i][j] == 0) {
						chk = false;
						break;
					}
				}
				//System.out.println();
			}
			//System.out.println("-----");
		}
		return chk;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		tomato = new int[h][n][m];
		isvisit = new boolean[h][n][m];
		q = new LinkedList<>();
		days = 0;
		tdays = 0;
		answer = 0;
		
		boolean c = true;
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					tomato[k][i][j] = Integer.parseInt(st.nextToken());
					if(tomato[k][i][j] == 0) {
						c = false;
					}
				}
			}
		}
		
		if(c) {
			answer = 0;
		}else {
			for(int k=0; k<h; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						if(tomato[k][i][j] == 1) {
							ArrayList<Integer> point = new ArrayList<>();
							point.add(i);
							point.add(j);
							point.add(k);
							
							q.offer(point);
							isvisit[k][i][j] = true;
						}
					}
				}
			}
			bfs();
		}

		if(!checkfunc()) {
			answer = -1;
		}
		System.out.println(answer);
		br.close();
	}
}
