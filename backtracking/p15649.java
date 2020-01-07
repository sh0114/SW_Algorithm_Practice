package bt;

import java.util.*;

public class p15649 {
	
	static int n,m;
	static Stack<Integer> stack;
	
	public static void back() {
		
		if(stack.size() == m) {
			for(int i=0; i<m; i++) {
				System.out.print(stack.get(i) + " ");
			}
			System.out.println();
			return;
			
		}else {
			for(int i=1; i<=n; i++) {
				boolean chk = true;
				for(int j=0; j<stack.size();j++) {
					if(stack.get(j) == i) {
						chk = false;
						break;
					}
				}
				if(chk) {
					stack.push(i);
					back();
					stack.pop();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		stack = new Stack<>();
		
		back();
		
		sc.close();
	}
}
