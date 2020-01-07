package Floyd;

import java.util.*;
import java.io.*;

public class p11404 {
	
	static int[][] city;
	static int n,m;
	
	public static void floyd() {
		for(int k = 1; k<=n; k++) {
			// ���İ��� ��� k ( �߰�����)
			for(int i=1; i<=n; i++) {
				// ����ϴ� ��� i
				for(int j=1; j<=n; j++) {
					// �����ϴ� ��� j
					// i - k - j �� i-j �� ����� ���Ͽ� �� ���� ����� �����Ѵ�.
					
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
