package stack;

import java.util.*;
import java.io.*;

public class p1874 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arrs = new int[n];
		Stack<Integer> stack = new Stack<>();
		Stack<String> result = new Stack<>();
		
		for(int i=0; i<n; i++) {
			arrs[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 1;
		for(int i=0; i<n; i++) {
			
			if(!stack.isEmpty()) {
				if(stack.peek() == arrs[i]) {
					stack.pop();
					result.push("-");
				}else {
					while(count <= arrs[i]) {
						stack.push(count);
						result.push("+");
						count++;
					}
					if(stack.peek() == arrs[i]) {
						stack.pop();
						result.push("-");
					}
				}
			}else {
				while(count <= arrs[i]) {
					stack.push(count);
					result.push("+");
					count++;
				}
				if(stack.peek() == arrs[i]) {
					stack.pop();
					result.push("-");
				}
			}
			
		}

		if(!stack.isEmpty()) {
			System.out.println("NO");
		}else {
			for(int i=0; i<result.size();i++) {
				System.out.println(result.get(i));
			}
		}
		
		br.close();
	}
}
