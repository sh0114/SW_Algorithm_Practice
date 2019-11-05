package stack;
import java.io.*;
import java.util.*;
public class p9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		Stack<String> stack = new Stack<>();
		boolean chk = false;
		
		while(tc-- > 0) {
			String s = sc.next();
			chk = false;
			for(int i=0; i< s.length(); i++) {

				if(s.substring(i,i+1).equals(")")) {
					if(stack.isEmpty()) {
						chk = true;
						System.out.println("NO");
						break;
					}else {
						stack.pop();	
					}
				}else {
					stack.push(s.substring(i,i+1));
				}
			}
			
			if(stack.isEmpty() && !chk) {
				System.out.println("YES");
			}else if(!chk) {
				System.out.println("NO");
				stack.clear();
			}
		}
		
		sc.close();
	}
}
