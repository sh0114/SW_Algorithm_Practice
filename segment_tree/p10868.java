package segtree;

import java.util.*;
import java.io.*;

public class p10868 {
	
	static int n, m;
	static int[] tree, arr;
	
	public static int init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		int l = init(node*2, start , mid);
		int r = init(node*2+1, mid+1, end);
		
		return tree[node] = Math.min(l, r);
	}
	
	public static int min(int node, int start, int end, int left, int right) {
		
		if(right < start || end < left) {
			return Integer.MAX_VALUE;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		int l = min(node*2, start, mid, left, right);
		int r = min(node*2+1, mid+1, end, left, right);
		
		return Math.min(l,r);
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tree = new int[4*n];
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1,1,n);
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int answer = min(1,1,n,a,b);
			System.out.println(answer);
		}
		
		br.close();
	}
}
