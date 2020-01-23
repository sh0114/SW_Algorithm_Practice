package bin;

import java.util.*;
import java.io.*;

public class p2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] tree = new long[n];
		st = new StringTokenizer(br.readLine());

		long max = 0;
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		long left =0;
		long right = max;
		
		long h = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for(int i=0; i<n; i++) {
				if(tree[i] - mid > 0) {
					sum += tree[i]-mid;
				}
			}
			if(sum>=m) {
				if(h < mid) {
					h = mid;
				}
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		System.out.println(h);
		br.close();
	}
}
