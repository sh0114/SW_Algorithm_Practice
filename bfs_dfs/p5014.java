package bfs_dfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p5014 {
	
	static boolean[] isvisit;
	static int f,s,g,u,d;
	static int count;
	
	public static boolean isRange(int a) {
		return (0<= a && a<=f);
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(s,0));
		isvisit[s] = true;
		
		while(!q.isEmpty()) {
			int cp = q.peek().x;
			int cc = q.poll().y;
			
			if(cp  == g) {
				count = cc;
				break;
			}
			
			int np = cp+u;
			if(isRange(np)&& !isvisit[np]) {
				q.offer(new Point(np,cc+1));
				isvisit[np] = true;
			}
			
			np = cp-d;
			if(isRange(np) && !isvisit[np]) {
				q.offer(new Point(np, cc+1));
				isvisit[np] = true;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		count  = -1;
		isvisit = new boolean[f+1];
		
		bfs();
		
		if(count<0) {
			System.out.println("use the stairs");
		}else {
			System.out.println(count);
		}
		
		br.close();
	}
}
