package bfsdfs;

import java.util.*;
import java.io.*;

public class p9019 {
	
	static class register{
		String command;
		int num;
		
		public register(String c, int n) {
			this.command = c;
			this.num = n;
		}
	}
	
	static Queue<register> q;
	static boolean[] isvisit;
	static int a, b;
	static String answer;
	
	public static void bfs(int first, int target) {
		
		q.offer(new register("", first));
		
		while(!q.isEmpty()) {
			String curcomm = q.peek().command;
			int curnum = q.peek().num;
			q.poll();
			
			if(curnum == target) {
				answer = curcomm;
				break;
			}
			
			// 1
			int dn = curnum*2;
			dn = dn%10000;
			if(!isvisit[dn]) {
				q.offer(new register(curcomm +"D", dn));
				isvisit[dn] = true;
			}
			
			//2
			int sn = 0;
			if(curnum ==0) {
				sn = 9999;
			}else {
				sn = curnum-1;
			}
			
			if(!isvisit[sn]) {
				q.offer(new register(curcomm +"S", sn));
				isvisit[sn] = true;
			}
			
			//3
			int ln = (curnum%1000)*10 + curnum/1000;
			
			if(!isvisit[ln]) {
				q.offer(new register(curcomm+"L", ln));
				isvisit[ln] = true;
			}
						
			//4
			int rn = (curnum%10)*1000 + (curnum/10);
			if(!isvisit[rn]) {
				q.offer(new register(curcomm+"R", rn));
				isvisit[rn] = true;
			}
		}	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			q = new LinkedList<>();
			isvisit = new boolean[10001];
			answer = "";
			
			bfs(a, b);
			System.out.println(answer);
			
		}
		
		br.close();
	}
}
