package dq;
import java.io.*;

public class p1992 {
	
	static String answer;
	
	public static void devide(int[][] mtree, int n) {
		if(n==1) {
			if(mtree[0][0] == 0) {
				answer = answer + "0";
			}else {
				answer = answer + "1";
			}
			return;
		}
		if(checktree(mtree, n)) {
			return;
		}
		
		answer = answer + "(";
		
		int[][] tree1 = copytree(mtree, 0,n/2,0,n/2,n/2);
		int[][] tree2 = copytree(mtree, 0,n/2, n/2, n, n/2);
		int[][] tree3 = copytree(mtree, n/2,n,0,n/2,n/2);
		int[][] tree4 = copytree(mtree, n/2,n,n/2,n,n/2);
		
		devide(tree1,n/2);
		devide(tree2, n/2);
		devide(tree3, n/2);
		devide(tree4, n/2);
		
		answer = answer + ")";
	}
	
	public static int[][] copytree(int[][] mtree, int si, int ei, int sj, int ej, int n) {
		int[][] ctree = new int[n][n];
		for(int i=si, ci =0; i<ei; i++, ci++) {
			for(int j=sj, cj = 0; j<ej; j++, cj++) {
				ctree[ci][cj] = mtree[i][j];
			}
		}
		return ctree;
	}
	
	
	public static boolean checktree(int[][] mtree, int n) {
		boolean c = true;
		int target = mtree[0][0];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(mtree[i][j] != target) {
					c = false;
					break;
				}
			}
		}
		if(c) {
			if(target == 0) {
				answer = answer + "0";
			}else {
				answer = answer + "1";
			}
		}
		return c;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		answer = "";
		
		int[][] tree = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				tree[i][j] = Integer.parseInt(s.substring(j,j+1));
			}
		}
		devide(tree, n);
		System.out.println(answer);
		br.close();
	}
}
