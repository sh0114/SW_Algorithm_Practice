package segtree;

import java.util.*;
import java.io.*;

public class p6549 {
	
	static int n;
	static int[] tree, arr;
	
	public static int init(int node, int start, int end) {
		
		if(start == end) {
			return tree[node] = start;
		}
		
		int mid = (start + end) / 2;
		int l = init(node*2, start , mid);
		int r = init(node*2+1, mid+1, end);
		
		if(arr[l] <= arr[r]) {
			tree[node] = l;
		}else {
			tree[node] = r;
		}
		return tree[node];
	}
	
	public static int solve(int node, int start, int end, int left, int right) {
		
		if(right < start || end < left) {
			return -1;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		int l = solve(node*2, start, mid, left, right);
		int r = solve(node*2+1, mid+1, end, left, right);
		
		if(l < 0) {
			return r;
		}else if(r<0) {
			return l;
		}else {
			if(arr[l] <= arr[r]) {
				return l;
			}else {
				return r;
			}
		}
	}
	
	public static long max(int left, int right) {
		int index = solve(1,1,n,left, right);
		long size = (long) (right-left + 1) * (long) arr[index];
		
		if(left <= index-1) {
			long res = max(left, index-1);
			if(size < res) {
				size = res;
			}
		}
		
		if(index+1 <= right) {
			long res = max(index+1, right);
			if(size < res) {
				size = res;
			}
		}
		
		return size;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] s = br.readLine().split(" ");
			
			n = Integer.parseInt(s[0]);
			
			if(n==0)
				break;
			
			tree = new int[4*n];
			arr = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			init(1,1,n);
			
			long answer = max(1,n);
			
			System.out.println(answer);
		}
		
		
		br.close();
	}
	
}
