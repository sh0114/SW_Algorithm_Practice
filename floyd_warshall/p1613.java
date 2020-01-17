package floyd;

import java.util.*;
import java.io.*;
import java.awt.*;

public class p1613 {
	
	static int[][] time;
	static int n, k, s;
	
	public static void floyd() {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(time[i][k] == 1 && time[k][j] ==1) {
						time[i][j] = 1;
					}else if(time[i][k] == -1 && time[k][j] == -1) {
						time[i][j] = -1;
					}
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		time = new int[n+1][n+1];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			time[a][b] = -1;
			time[b][a] = 1;
		}
		
		floyd();
		
		s = Integer.parseInt(br.readLine());
		
		for(int i=0; i<s; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(time[a][b]);
		}
		
		br.close();
	}
}
