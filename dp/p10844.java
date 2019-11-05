package dp;
import java.util.*;
import java.io.*;
public class p10844 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long result = 0;
		// % 1000000000
		
		long[][] arr = new long[n+1][10];
		for(int i=1; i<=9; i++) {
			arr[1][i] = 1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0; j<=9; j++) {
				if(j == 0) {
					arr[i][j] = arr[i-1][j+1] % 1000000000;
				}else if(j == 9) {
					arr[i][j] = arr[i-1][j-1] % 1000000000;
				}else {
					arr[i][j] = (arr[i-1][j-1]+ arr[i-1][j+1]) % 1000000000;
				}
			}
		}
		
		for(int i= 0; i<=9;i++) {
			result += arr[n][i];
		}
		
		System.out.println(result % 1000000000);
		br.close();
	}
}
