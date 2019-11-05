package dp;
import java.io.*;
public class p2748 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long [] arr = new long[91];
		arr[0] = 0; arr[1] = 1;
		for(int i=2; i<=n;i++) {
			arr[i] = arr[i-1]+ arr[i-2];
		}
		System.out.println(arr[n]);

		br.close();
	}
}
