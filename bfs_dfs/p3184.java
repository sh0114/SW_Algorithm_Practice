package bfs;
import java.awt.Point;
import java.io.*;
import java.util.*;
public class p3184 {
	static int sumsheep, tempsheep, sumwolf, tempwolf;
	static char[][] ground;
	static int r, c;
	
	public static boolean isRange(int ax, int ay) { 
		// 마당을 벗어 나는지 아닌지 확인
		return (0<=ax && ax <r) && (0<=ay & ay<c);
	}
	
	public static void isSurvive() {
		// 양이 살아남는지, 늑대가 살아남는지 확인
		if(tempsheep>tempwolf)
			sumsheep += tempsheep;
		else
			sumwolf += tempwolf;
		
		tempsheep = tempwolf = 0;
	}
	
	public static void bfs(int a, int b) {
		// 너비 우선 탐색
		
		int x, y, ax, ay;
		int[] dx = {0, 0,-1, 1};
		int[] dy = {1,-1,0,0};
		// 상하좌우로 이동
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(a,b));
		
		if(ground[a][b] == 'v') tempwolf++;
		else if(ground[a][b] =='o') tempsheep++;
		
		ground[a][b] = '#';
		
		while(!q.isEmpty()) {
			x = q.peek().x; y = q.poll().y;
			for(int i=0; i<4; i++) {
				ax = x+dx[i]; ay = y+dy[i];
				if(isRange(ax, ay) && ground[ax][ay] != '#') {
					if(ground[ax][ay] == 'v')
						tempwolf++;
					else if(ground[ax][ay] =='o')
						tempsheep++;
					ground[ax][ay]='#';
					q.offer(new Point(ax,ay));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		ground = new char[r][c];
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				ground[i][j] = line.charAt(j);
			}
		}
		
		for(int i= 0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(ground[i][j] !='#') {
					bfs(i,j);
					isSurvive();
				}
			}
		}
		System.out.println(sumsheep + " " + sumwolf);
		br.close();
	}
}
