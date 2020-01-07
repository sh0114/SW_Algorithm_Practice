package dq;

import java.util.*;
import java.io.*;

public class p1780 {

	static int[][] map;
	static int cntp0, cntp1,cntp_1;

	public static void devide(int[][] tmap, int tn) {
		
		if (tn == 1) {
			switch(tmap[0][0]) {
			case -1:
				cntp_1++;
				break;
			case 0:
				cntp0++;
				break;
			case 1:
				cntp1++;
				break;
			}
			return;
		}

		if (checkpaper(tmap, tn)) {
			return;
		}
		
		int[][] tmap_1 = copy(tmap, 0, tn / 3, 0, tn / 3, tn / 3);
		int[][] tmap_2 = copy(tmap, 0, tn / 3, tn / 3, tn * 2 / 3, tn / 3);
		int[][] tmap_3 = copy(tmap, 0, tn / 3, tn * 2 / 3, tn, tn / 3);

		int[][] tmap_4 = copy(tmap, tn / 3, tn * 2 / 3, 0, tn / 3, tn / 3);
		int[][] tmap_5 = copy(tmap, tn / 3, tn * 2 / 3, tn / 3, tn * 2 / 3, tn / 3);
		int[][] tmap_6 = copy(tmap, tn / 3, tn * 2 / 3, tn * 2 / 3, tn, tn / 3);

		int[][] tmap_7 = copy(tmap, tn * 2 / 3, tn, 0, tn / 3, tn / 3);
		int[][] tmap_8 = copy(tmap, tn * 2 / 3, tn, tn / 3, tn * 2 / 3, tn / 3);
		int[][] tmap_9 = copy(tmap, tn * 2 / 3, tn, tn * 2 / 3, tn, tn / 3);

		devide(tmap_1, tn / 3);
		devide(tmap_2, tn / 3);
		devide(tmap_3, tn / 3);
		devide(tmap_4, tn / 3);
		devide(tmap_5, tn / 3);
		devide(tmap_6, tn / 3);
		devide(tmap_7, tn / 3);
		devide(tmap_8, tn / 3);
		devide(tmap_9, tn / 3);

	}

	public static int[][] copy(int[][] tmap, int si, int ei, int sj, int ej, int tn) {
		int[][] cmap = new int[tn][tn];
		for (int i = si, ti = 0; i < ei; i++, ti++) {
			for (int j = sj, tj = 0; j < ej; j++, tj++) {
				cmap[ti][tj] = tmap[i][j];
			}
		}
		return cmap;
	}

	public static boolean checkpaper(int[][] tmap, int tn) {
		
		int target = tmap[0][0];
		boolean c = true;
		for (int i = 0; i < tn; i++) {
			for (int j = 0; j < tn; j++) {
				if (tmap[i][j] != target) {
					c = false;
					break;
				}
			}
		}
		
		if(c) {
			switch(target) {
			case -1:
				cntp_1++;
				break;
			case 0:
				cntp0++;
				break;
			case 1:
				cntp1++;
				break;
			}
		}
		
		return c;
	}
	
//	public static void tmapprint(int[][] tmap) {
//		int n = tmap[0].length;
//		System.out.println("----------tmap---------");
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(tmap[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		cntp_1 = 0;
		cntp0 = 0;
		cntp1 = 0;
		
		int[][] tmap = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tmap[i][j] = map[i][j];
			}
		}
		
		devide(tmap, n);
		System.out.println(cntp_1);
		System.out.println(cntp0);
		System.out.println(cntp1);

		br.close();
	}
}
