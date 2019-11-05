package stack;
import java.util.*;
public class p10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String w = sc.next();
		Stack<String> s = new Stack<>();
		s.push(w.substring(0,1));
		int count = 0;
		for(int i=1; i<w.length(); i++) {
			if(w.substring(i,i+1).equals(")")) {
				s.pop();
				if(w.substring(i-1,i).equals(")"))
					count++;
				else
					count += s.size();
			}else {
				s.push(w.substring(i,i+1));
			}
		}
		System.out.println(count);
		sc.close();
	}
}
