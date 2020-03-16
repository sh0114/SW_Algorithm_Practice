package segtree;

import java.util.*;
import java.io.*;

public class p2357 {

	public static class node {
		int min;
		int max;

		public node(int min, int max) {
			this.max = max;
			this.min = min;
		}
	}

	static int n, m;
	static int[] arr;
	static node[] tree;

	public static node init(int index, int start, int end) {
		if (start == end) {
			return tree[index] = new node(arr[start], arr[start]);
		}

		int mid = (start + end) / 2;

		node l = init(index * 2, start, mid);
		node r = init(index * 2 + 1, mid + 1, end);

		int min = Math.min(l.min, r.min);
		int max = Math.max(l.max, r.max);

		return tree[index] = new node(min, max);
	}

	public static node solve(int index, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return new node(Integer.MAX_VALUE, -99999);
		}

		if (left <= start && end <= right) {
			return tree[index];
		}

		int mid = (start + end) / 2;

		node l = solve(index * 2, start, mid, left, right);
		node r = solve(index * 2 + 1, mid + 1, end, left, right);
		
		int min = Math.min(l.min, r.min);
		int max = Math.max(l.max, r.max);
		
		return new node(min, max);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		tree = new node[4 * n];
		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		init(1,1,n);
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			node ans = solve(1,1,n,left, right);
			System.out.println(ans.min + " " + ans.max);

		}

		br.close();
	}
}
