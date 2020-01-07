package stack;

import java.util.*;
import java.awt.*;

public class p2800 {
	
	static Stack<Point> pstack;
	static Stack<String> sstack;
	static Stack<Point> setstack;
	static String[] exparr;
	static String[] temparr;
	static String expression;
	static int len;
	
	
	public static void solve(int index) {

		int x = setstack.get(index).x;
		int y = setstack.get(index).y;
		
		exparr[x] = "";
		exparr[y] = "";
		
		String ans = "";
		
		for(int i=0; i<len; i++) {
			if(i == x || i == y) {
				continue;
			}else {
				ans = ans+exparr[i];
			}
		}
		
		sstack.add(ans);
	
	}
	
	public static void insert(int index) {
		int x = setstack.get(index).x;
		int y = setstack.get(index).y;
		
		exparr[x] = temparr[x];
		exparr[y] = temparr[y];
	}
	
	public static void comb(int n, int r, int index) {
		if(r==0) {
			for(int i=0; i<setstack.size(); i++) {
				solve(i);
			}
			for(int i=0; i<setstack.size(); i++) {
				insert(i);
			}
			return;
		}else if(n==r) {
			for(int i=0; i<n; i++) {
				setstack.push(pstack.get(index+i));
			}
			for(int i=0; i<setstack.size(); i++) {
				solve(i);
			}
			for(int i=0; i<setstack.size(); i++) {
				insert(i);
			}
			for(int i=0; i<n; i++) {
				setstack.pop();
			}
		}else {
			setstack.push(pstack.get(index));
			comb(n-1, r-1,index+1);
			setstack.pop();
			comb(n-1,r,index+1);
		}
	}
	
	public static void pprint() {
		System.out.println("-----pprint-----");
		for(int i=0; i<pstack.size(); i++) {
			System.out.println(pstack.get(i));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		expression = sc.next();
		sstack = new Stack<>();
		Stack<Integer> istack = new Stack<>();
		pstack = new Stack<>(); 
		setstack = new Stack<>();
		
		len = expression.length();
		exparr = new String[len];
		temparr = new String[len];
		
		for(int i=0; i<len; i++) {
			String e = expression.substring(i,i+1);
			exparr[i] = e;
			temparr[i] = e;
		}
		
		int lindex = 0, rindex = 0;
		
		for(int i=0; i<len; i++) {
			String e = expression.substring(i,i+1);
			if(e.equals("(")) {
				istack.add(i);
			}else if(e.equals(")")) {
				lindex = istack.pop();
				rindex = i;		
				pstack.add(new Point(lindex,rindex));
			}
		}	
		
		int n = pstack.size();
		for(int i=1; i<=n; i++) {
			comb(n,i,0);
		}
		
		int slen = sstack.size();
		String[] ansarr = new String[slen];
		
		for(int i=0; i<sstack.size(); i++) {
			ansarr[i] = sstack.get(i);
		}
		
		Arrays.sort(ansarr);
		
		for(int i=0; i<sstack.size(); i++) {
			if(i==0) {
				System.out.println(ansarr[i]);
			}else {
				if(!ansarr[i].equals(ansarr[i-1])) {
					System.out.println(ansarr[i]);
				}
			}
		}
		
		sc.close();
	}
}
