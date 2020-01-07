package q;

import java.io.*;
import java.util.*;
import java.awt.*;

public class p2606 {
	
	static Queue<Point> q;
	static boolean[][] computer;
	static boolean[] isvisit;
	static int n, pair, answer;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for(int i=1; i<=n; i++) {
				if(computer[y][i] && !isvisit[i]) {
					q.offer(new Point(y,i));
					isvisit[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		answer = 0;
		
		q = new LinkedList<>();
		
		computer = new boolean[n+1][n+1];
		isvisit = new boolean[n+1];
		for(int i=0; i<pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			computer[s][e] = true;
			computer[e][s] = true;
			if(s==1) {
				q.offer(new Point(s,e));
				isvisit[e] = true;
			}
		}
		
		bfs();
		
		
		for(int i=1; i<=n; i++) {
			if(isvisit[i]) {
				answer++;
			}
		}
		answer--;
		System.out.println(answer);
		
		br.close();
	}
}
