package segtree;

import java.io.*;

public class p1849 {
	
	static int n;
	static int[] tree;
	
	public static void update(int node, int index, int diff, int start, int end) {
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
	
	public static int query(int node, int value, int start, int end) {
		
		if(start == end) {
			return start;
		}
		
		int mid = (start + end) / 2;
		
		if(node*2 < 4*n && value < tree[node*2]) {
			return query(node*2,value,start, mid);
		}
		
		value -= tree[node*2];
		
		return query(node*2+1, value, mid+1, end);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		tree = new int[4*n];
		
		for(int i=1; i<=n; i++) {
			update(1,i,1,1,n);
		}
		
		int[] ans = new int[n+1];

		for(int i=1; i<=n; i++) {
			int value = Integer.parseInt(br.readLine());
			
			int index = query(1,value,1,n);
			ans[index] = i;
			update(1,index,-1,1,n);
		}

		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<=n; i++) {
			bw.write(Integer.toString(ans[i])+"\n");
		}
		bw.flush();
		
		br.close();
		bw.close();
		
	}
}
