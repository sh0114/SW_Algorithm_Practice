package binary;
import java.io.*;
import java.util.*;
public class p10816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> nmap = new HashMap<>();
		for(int i=0; i<n ;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(nmap.containsKey(a)) {
				nmap.replace(a, nmap.get(a) + 1);
			}else {
				nmap.put(a, 1);
			}
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m;i++) {
			int a = Integer.parseInt(st.nextToken());
			int res = 0;
			if(nmap.containsKey(a)) {
				res = nmap.get(a);
			}
			System.out.print(res);
			System.out.print(" ");
		}
		System.out.println();
		br.close();
	}

}
// 아니 해시맵으로 이걸 풀었네...ㄷㄷ
//	static int[] narr;
//	static int[] marr;
//	
//	public static int binarySearch(int left, int right, int count, int i) {
//		int res;
//		if(left > right) {
//			return count;
//		}else {
//			int mid = (left + right) / 2;
//			if(narr[mid] < marr[i]) {
//				left = mid+1;
//				res = binarySearch(left, right,count,i);
//			}else if(narr[mid] > marr[i]) {
//				right = mid-1;
//				res = binarySearch(left, right,count,i);
//			}else {
//				res = binarySearch(left, mid-1,count,i);
//				res += binarySearch(mid+1, right, count,i);
//				res++;
//			}
//			return res;
//
//		}
//	}
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		narr = new int[n];
//		for(int i=0; i<n ;i++) {
//			narr[i] = Integer.parseInt(st.nextToken());
//		}
//		int m = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		
//		marr = new int[m];
//		for(int i=0; i<m;i++) {
//			marr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(narr);
//		
//		for(int i=0; i<m;i++) {
//			int left = 0;
//			int right = n-1;
//			int count = 0;
//			count = binarySearch(left, right, count, i);
//			System.out.print(count);
//			System.out.print(" ");
//		}
//		
//		
//		System.out.println();
//		
//		br.close();
//	}
//}
