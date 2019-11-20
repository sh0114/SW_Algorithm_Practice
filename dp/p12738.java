package dp;

import java.util.*;
import java.io.*;

public class p12738 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());


		arr[0] = Integer.parseInt(st.nextToken());
		int size = 1;

		for (int i = 1; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (arr[size - 1] < a)
				arr[size++] = a;
			else {
				int l = 0;
				int r = size;
				int m = 0;
				while (l < r) {
					m = (l + r) / 2;
					if (arr[m] < a)
						l = m + 1;
					else
						r = m;
				}
				arr[r] = a;
			}
		}

		System.out.println(size);
		br.close();
	}
}
