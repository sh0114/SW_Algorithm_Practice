package bfsdfs;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p1525 {
	
	static int puzzle;
	static int answer;
	
	public static boolean isRange(int a, int b) {
		return (0<=a && a<3) && (0<=b && b<3);
	}

	public static void bfs() {
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(puzzle, 0);
		q.offer(puzzle);
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			String curstr = Integer.toString(cur);
			
			if(cur == 123456789) {
				answer = map.get(cur);
				break;
			}
			
			int zero = curstr.indexOf("9");
			int x = zero/3;
			int y = zero%3;
			
			for(int i=0; i<4; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				if(isRange(ax,ay)) {
					int nzero = ax*3 + ay;
					String nstr = swap(curstr, zero, nzero);
					int next = Integer.parseInt(nstr);
					
					if(!map.containsKey(next)) {
						map.put(next, map.get(cur)+1);
						q.offer(next);
					}
				}
			}
		}
		
	}
	
	public static String swap(String cstr, int cur, int next) {
		StringBuilder nstr = new StringBuilder(cstr);
		char temp = nstr.charAt(next);
		nstr.setCharAt(cur, temp);
		nstr.setCharAt(next, '9');
		String n = nstr.toString();
		return n;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		puzzle = 0;
		answer = -1;
		
		String pstr = "";
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int in = Integer.parseInt(st.nextToken());
				if(in == 0) {
					in = 9;
				}
				puzzle = (puzzle*10)+in;
			}
		}
		bfs();
		System.out.println(answer);
		
		br.close();
	}
}
