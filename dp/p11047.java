package dp;
import java.io.*;
import java.util.*;
public class p11047 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		
		for(int i=0; i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long sum = 0;
		int count = 0;
		for(int i=n-1; i>=0; i--) {
			while(k-sum>=arr[i]) {
				sum += arr[i];
				count++;
			}
			if(k==sum) {
				break;
			}
		}
		System.out.println(count);
		br.close();
	}
}
