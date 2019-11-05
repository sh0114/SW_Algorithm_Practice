package binary;
import java.util.*;

public class p10815 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] narr = new int[n];
		for(int i=0; i<n;i++) {
			narr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] marr = new int[m];
		for(int j=0; j<m; j++) {
			marr[j] = sc.nextInt();
		}
		
		Arrays.sort(narr);
		

		for(int i=0; i<m; i++) {
			int left = 0;
			int right = n-1;
			
			while(left <= right) {
				if(narr[(left+right)/2] < marr[i]) {
					left = (left+right)/2 + 1;
				}else if(narr[(left+right)/2] > marr[i]){
					right = (left+right)/2 -1;
				}else {
					System.out.print(1);
					System.out.print(" ");
					break;
				}
			}
			
			if(left>right) {
				System.out.print(0);
				System.out.print(" ");
			}
			
		}
		System.out.println();

		sc.close();
	}
}
