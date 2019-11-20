package stack;

import java.util.*;
import java.io.*;

public class p9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		String target = br.readLine();

		Stack<Character> stack = new Stack<>();

		int len = string.length();
		int tlen = target.length();
		for (int i = 0; i < len; i++) {
			char c = string.charAt(i);
			stack.push(c);


			if (c == target.charAt(tlen - 1) && stack.size() >= tlen) {
				boolean istarget = true;
				
				int index = stack.size();
				for (int j = 1; j<=tlen; j++) {
					if(stack.get(index-j) != target.charAt(tlen-j)) {
						istarget = false;
					}
				}
				
			
				if(istarget) {
					index = stack.size();
					
					for (int j = index-1; j >= index - tlen; j--) {

						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}else {
			for(int i=0; i<stack.size(); i++) {
				System.out.print(stack.get(i));
			}
			System.out.println();
		}

		br.close();

	}
}
