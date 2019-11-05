package queue;
import java.util.*;
import java.io.*;
public class p10845 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				q.offer(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("pop")) {
				if(!q.isEmpty()) {
					System.out.println(q.poll());
				}else {
					System.out.println(-1);
				}
			}else if(cmd.equals("size")) {
				System.out.println(q.size());
			}else if(cmd.equals("empty")) {
				if(q.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				
			}else if(cmd.equals("front")) {
				if(!q.isEmpty()) {
					System.out.println(q.peek());
				}else {
					System.out.println(-1);
				}
			}else if(cmd.equals("back")) {
				if(!q.isEmpty()) {
					System.out.println(q.get(q.size()-1));
				}else {
					System.out.println(-1);
				}
			}
		}
		br.close();
	}
}
