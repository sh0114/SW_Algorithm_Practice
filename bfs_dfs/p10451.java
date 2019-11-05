package dfs;
import java.util.*;
import java.io.*;
public class p10451 {
	static int n;
	static int[][] arr;
	static boolean[] isvisit;
	
	public static void dfs(int a, int f) {
		boolean chk = false;
		for(int i=0; i<n; i++) {
			if(arr[0][i] == a && !isvisit[i]) {
				isvisit[i] = true;
				if(arr[1][i] == f) {
					return;
				}else {
					dfs(arr[1][i], f);
				}
			}
		}
		if(!chk) {
			return;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr = new int[2][n];
			isvisit = new boolean[n];
			
			int[] temp = new int[n];
			for(int i=0; i<n; i++) {
				temp[i] = Integer.parseInt(st.nextToken());
				arr[1][i] = temp[i];
			}
			Arrays.sort(temp);
			for(int i=0; i<n; i++) {
				arr[0][i] = temp[i];
			}
			
			int count = 0;
			for(int i=0; i<n; i++) {
				if(!isvisit[i]) {
					dfs(arr[1][i],arr[0][i]);
					count++;
				}
			}
			System.out.println(count);
			
		}
		
		br.close();
	}
}
