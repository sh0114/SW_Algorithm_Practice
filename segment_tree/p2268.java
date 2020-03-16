package segtree;

import java.util.*;
import java.io.*;

public class p2268 {
	
	static int n,m;
	static long[] tree, arr;
	
	public static void update(int node, int index, long diff, int start , int end) {
		if(index < start || end < index) {
			return;
		}
		
		tree[node] += diff;
		
		if(start != end) {
			
			int mid = (start + end) / 2;
			update(node*2, index, diff, start, mid);
			update(node*2+1, index, diff, mid+1, end);
		}
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		if(right <start || end < left) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		long l = sum(node * 2, start , mid, left, right);
		long r = sum(node*2+1, mid+1, end, left, right);
		
		return l+r;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tree = new long[4*n];
		arr = new long[n+1];
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==0) {
				if(b>c) {
					int t = b;
					b = c;
					c = t;
				}
				System.out.println(sum(1,1,n,b,c));
			}else if(a==1) {
				update(1,b,c-arr[b],1,n);
				arr[b] = c;
			}
		}
		
		br.close();
	}
}
