package segtree;

import java.io.*;
import java.util.*;

public class p11505 {
	
	static final int rem = 1000000007;
	static int n, m, k;
	static long[] tree;
	static int[] arr;
	
	public static long init(int node, int start, int end) {
		
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end)/2;
		return tree[node] = (init(node*2, start, mid) * init(node*2+1, mid+1, end)) % rem;
	}
	
	public static long update(int node, int index, long num, int start, int end) {
		
		if(start == index && start == end) {
			return tree[node] = num;
		}
		
		if(start <= index && index <= end) {
			int mid = (start + end) / 2;
			long a = update(node*2, index, num, start, mid);
			long b = update(node*2+1, index, num, mid+1, end);
			return tree[node] = a*b%rem;
		}
		
		return tree[node];
		
	}
	
	public static long mul(int node, int start, int end, int left, int right) {
		
		if(right < start || end < left)
			return 1;
		
		if(left <= start && end <= right)
			return tree[node];
		
		int mid = (start + end) / 2;
		
		return (mul(node * 2, start, mid, left, right) * mul(node*2 + 1, mid+1, end, left, right)) % rem;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		tree = new long[4*n];
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1,1,n);	
		
		m += k;
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1) {
				update(1,b,c,1,n);
			}else if(a==2) {
				System.out.println(mul(1,1,n,b,c));
			}
		}
		
		br.close();
	}
}
