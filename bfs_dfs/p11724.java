package dfs;
import java.util.*;
import java.io.*;

public class p11724 {
	static int n, m;
	static int[][] arr;
	static boolean[] isvisit;
	
	public static void dfs(int node) {
		
		isvisit[node] = true;
		
		for(int i = 1; i<=n; i++) {
			if(arr[node][i] == 1 && !isvisit[i]) {
				dfs(i);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		isvisit = new boolean[n+1];
		for(int i=0; i< m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		int count = 0;
		for(int i=1; i<=n; i++) {
			if(!isvisit[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
}
