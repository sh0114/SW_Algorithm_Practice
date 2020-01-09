package bfsdfs;

import java.util.*;
import java.awt.*;

public class p1697 {
	
	static boolean[] isvisit;
	static int n, k, time;
	
	public static boolean isRange(int a) {
		return (0<=a && a<=100000);
	}
	
	public static void bfs() {
		
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(n,0));
		isvisit[n] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int t = q.poll().y;
			if(x == k) {
				time = t;
				break;
			}
			
			if(isRange(x-1)) {
				if(!isvisit[x-1]) {
					isvisit[x-1] = true;
					q.offer(new Point(x-1,t+1));
				}
			}
			
			if(isRange(x+1)) {
				if(!isvisit[x+1]) {
					isvisit[x+1] = true;
					q.offer(new Point(x+1,t+1));
				}
			}
			
			if(isRange(2*x)) {
				if(!isvisit[2*x]) {
					isvisit[2*x] = true;
					q.offer(new Point(2*x,t+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		time = 0;
		
		isvisit = new boolean[200001];
		
		bfs();
		
		System.out.println(time);
		sc.close();
	}
}
