package segtree;

import java.util.*;
import java.io.*;

public class p7578 {
	
	static int n;
	static long[] tree;
	
	public static void update(int node, int index, long diff, int start, int end) {
		if(index<start || end < index) {
			return;
		}
		tree[node] +=diff;
		
		if(start != end) {
			int mid = (start + end) / 2;
			update(node*2, index, diff, start , mid);
			update(node*2+1, index, diff, mid+1, end);
		}
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		if(right < start || end < left) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) /2;
		
		return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[n+1];
		tree = new long[4*n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			int value = Integer.parseInt(st.nextToken());
			map.put(value, i);
		}
		
		long answer = 0;
		
		for(int i=1; i<=n; i++) {
			int index = map.get(arr[i]);
			
			if(index+1 <=n)
				answer += sum(1,1,n,index+1,n);
					
			update(1,index,1,1,n);
		}
		
		System.out.println(answer);
	}
}
