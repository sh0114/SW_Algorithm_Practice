package Floyd;

import java.util.*;
import java.io.*;

public class p11404 {
	
	static int[][] city;
	static int n,m;
	
	public static void floyd() {
		for(int k = 1; k<=n; k++) {
			// 거쳐가는 노드 k ( 중간지점)
			for(int i=1; i<=n; i++) {
				// 출발하는 노드 i
				for(int j=1; j<=n; j++) {
					// 도착하는 노드 j
					// i - k - j 와 i-j 의 비용을 비교하여 더 적은 비용을 선택한다.
					
					city[i][j] = Math.min(city[i][k] + city[k][j], city[i][j]);
				}
			}

		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		city = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j)
					continue;
				else
					city[i][j] = 1000000;
			}
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			city[s][e] = Math.min(city[s][e], t);
		}
		

		
		floyd();
		

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(city[i][j] == 1000000) {
					System.out.print("0 ");
				}else {
					System.out.print(city[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		br.close();
	}
}
