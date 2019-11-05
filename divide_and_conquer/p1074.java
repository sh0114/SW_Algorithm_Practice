package divideandconquer;
import java.util.*;
import java.io.*;
public class p1074 {
	static int[][] arr;
	public static int daq(int n, int r, int c) {
		if(n == 1) {
			r = r%2;
			c = c%2;
			if(r==0&&c==0) {
				return 0;
			}else if(r==0&&c==1) {
				return 1;
			}else if(r==1&&c==0) {
				return 2;
			}else {
				return 3;
			}
		}else {
			int n2_1 = (int)Math.pow(2, n-1);
			int n4_1 = (int)Math.pow(4, n-1);
			int n2 = (int)Math.pow(2, n);
			n = n-1;

			int res = 0;
			if(0<=r && r<n2_1 && 0<=c && c<n2_1) {
				res = 0 + daq(n,r,c);
				return res;
			}else if(0<=r && r<n2_1 && n2_1<=c&&c<n2) {
				c = c - 1*n2_1;
				res =  1*n4_1 + daq(n,r,c);
				return res;
			}else if(n2_1<=r&&r<n2 && 0<=c && c<n2_1) {
				r = r - 1*n2_1;
				res =  2*n4_1 + daq(n,r,c);
				return res;
			}else {
				r = r - 1*n2_1;
				c = c - 1*n2_1;
				res =  3*n4_1 + daq(n,r,c);
				return res;
			}
				
			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int res = daq(n,r,c);
		
		System.out.println(res);
		
		br.close();
	}
}
