package bin;

import java.util.*;
import java.io.*;

public class p2110 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Long> house = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			house.add(Long.parseLong(br.readLine()));
		}
		
		Collections.sort(house);
		
		long left = 1;
		long right = house.get(n-1)-house.get(0);
		
		long answer = 0;
		while(left<=right) {
			long mid = (left + right) / 2;
			long cnt = 1; 
			long wifi = house.get(0);
			
			for(int i=1; i<n; i++) {
				if(house.get(i) - wifi >= mid) {
					cnt++;
					wifi = house.get(i);
				}
			}
			
			if(cnt>= m) {
				if(mid > answer)
					answer = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
