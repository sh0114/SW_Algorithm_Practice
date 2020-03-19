package segtree;

import java.util.*;
import java.io.*;

public class p1275 {
	
	static int n, q;
	static long[] tree, arr;
	
	public static long init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	
	public static void update(int node, int index, long diff, int start , int end) {
		
		if(index < start || end < index) {
			return;
		}
		
		tree[node] += diff;
		
		if(start != end) {
			int mid = (start + end) /2;
			update(node*2, index, diff, start, mid);
			update(node*2+1, index, diff, mid+1, end);
		}
		
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		
		if(right< start || end < left) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end)/2;
		
		return sum(node*2, start, mid, left, right) + sum(node*2+1,mid+1, end, left, right);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		tree = new long[4*n];
		arr = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		init(1,1,n);
		
		while(q-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(x>y) {
				int temp = x;
				x = y;
				y = temp;
			}
			
			long answer = sum(1,1,n,x,y);
			update(1,a,b-arr[a],1,n);
			arr[a] = b;
			System.out.println(answer);
			
		}
		
		
		br.close();
	}
}
