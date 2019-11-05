package divideandconquer;
import java.util.*;
import java.io.*;
public class p2630 {
	static int[][] arr;
	static int blue;
	static int white;
	static int t;

	public static void daq(int n, int a, int b) {
		if(n == 1) {
			if(arr[a][b] == 1) 
				blue++;
			else
				white++;
		}else {
			boolean chk = true;
			int color = arr[a][b];
			
			for(int i=a; i<a+n; i++) {
				for(int j=b; j<b+n; j++) {
					if(arr[i][j] != color) {
						chk = false;
						break;
					}
				}
			}
			
			if(!chk) {
				n = n/2;			
				daq(n, a,b);
				daq(n,a,b+n);
				daq(n,a+n,b);
				daq(n,a+n, b+n);
			}else {
				if(color == 1)
					blue++;
				else
					white++;
			}
			
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		arr = new int[t][t];
		blue = 0;
		white = 0;
		StringTokenizer st;
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<t; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		daq(t,0,0);
		System.out.println(white);
		System.out.println(blue);
		br.close();
	}
}
