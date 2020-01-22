package bfsdfs;

import java.util.*;
import java.io.*;

public class p12963 {

	static class street {
		int x;
		int y;
		int num;

		street(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	static boolean[] isvisit;
	static long[] weight;
	static int[][] map;
	static int n, m , mod;
	
	static boolean dfs(int cur) {
		isvisit[cur] = true;
		
		if(cur == n-1) {
			return true;
		}
		
		boolean chk = false;
		for(int i=0; i<n; i++) {
			if(map[cur][i] == 1) {
				if(!isvisit[i]) {
					chk |= dfs(i);
					// chk가 true로 됐는데 이후 dfs 결과에서 false가 나왔을 때를 방지함!!!!
				}
			}
		}
		return chk;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		mod = 1000000007;
		weight = new long[m+1];
		map = new int[n+1][n+1];
		
		Stack<street> edge = new Stack<>();
		
		for(int i=0,cnt=0; i<m; i++, cnt++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge.push(new street(a,b,cnt));
			
			if(i == 0) {
				weight[i] = 1;
			}else {
				weight[i] = (weight[i-1]*3);
				weight[i] %= mod;
			}
		}
		
		long answer = 0;
		
		while(!edge.isEmpty()) {
			
			isvisit = new boolean[n+1];
			int x = edge.peek().x;
			int y = edge.peek().y;
			int num = edge.peek().num;
			edge.pop();
			
			map[x][y] = 1;
			map[y][x] = 1;
			//System.out.println("x : " + x + " y : " + y + " num : " + num + " chk : " + hello);
			if(dfs(0)) {
				map[x][y] = 0;
				map[y][x] = 0;
				answer += weight[num];
				answer %= mod;
			}

		}
		
		System.out.println(answer);

		br.close();
	}
}
