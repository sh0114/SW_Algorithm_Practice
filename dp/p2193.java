package dp;

import java.io.*;

public class p2193 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] bin = new long[n+1][2];
		
		bin[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			bin[i][0] = bin[i-1][0] + bin[i-1][1];
			bin[i][1] = bin[i-1][0];
		}
		
		long answer = bin[n][0] + bin[n][1];
		System.out.println(answer);
		
		br.close();
	}
}
