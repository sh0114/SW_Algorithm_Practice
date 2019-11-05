package stack;
import java.util.*;
public class p2309 {
	static int[] nanzang;
	static Stack<Integer> s;
	static int[] result;
	public static void comb(int n, int r, int i) {
		if(r == 0) {
			calc();
		}else if(n == r) {
			for(int j=0; j<n; j++) {
				s.push(nanzang[i + j]);
			}
			calc();
			for(int j=0; j<n; j++) {
				s.pop();
			}
		}else {
			s.push(nanzang[i]);
			comb(n-1,r-1, i+1);
			s.pop();
			comb(n-1,r,i+1);
		}
	}
	
	public static void calc() {
		int sum = 0;
		for(int i=0; i<7; i++) {
			sum += s.get(i);
		}
		if(sum == 100) {
			for(int i=0; i<7; i++) {
				result[i] = s.get(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nanzang = new int[9];
		result = new int[7];
		s = new Stack<>();
		for(int i=0; i<9; i++) {
			nanzang[i] = sc.nextInt();
		}
		
		comb(9,7,0);
		
		Arrays.sort(result);
		for(int i=0; i<7; i++) {
			System.out.println(result[i]);
		}
		sc.close();
	}
}
