package bfsdfs;
import java.util.*;
import java.io.*;
import java.awt.*;

public class p11403 {
	
	static int[][] graph;
	static int n;
	
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		boolean[] isvisit = new boolean[n];
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i=0; i<n; i++) {
				if(graph[x][i] == 1 && !isvisit[i]) {
					q.offer(i);
					graph[a][i] = 1;
					isvisit[i] = true;
				}
			}
		}
	}
	
	public static void graph_print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			bfs(i);
		}
		
		graph_print();
		
		br.close();
	}
}
