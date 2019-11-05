package stack;

import java.util.*;

public class p2841 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();

		Stack<Integer>[] stack = new Stack[n];

		for (int i = 0; i < n; i++) {
			stack[i] = new Stack<>();
		}
		int count = 0;

		for (int i = 0; i < n; i++) {
			int line = sc.nextInt();
			int plat = sc.nextInt();

			if (stack[line].isEmpty()) {
				stack[line].push(plat);
				count++;
				continue;
			}
			if (stack[line].peek() < plat) {
				stack[line].push(plat);
				count++;
				continue;
			}


			while (stack[line].peek() > plat) {
				stack[line].pop();
				count++;
				if (stack[line].isEmpty()) {
					break;
				}
			}
			
			if (!stack[line].isEmpty() && stack[line].peek() == plat)
				continue;
			
			stack[line].push(plat);
			count++;
		}

		System.out.println(count);

		sc.close();
	}
}
