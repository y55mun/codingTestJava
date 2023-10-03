package brute_force;

import java.io.*;
import java.util.*;

public class c6_9663 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		n = scan.nextInt();
		col = new int[n+1];	// col[i]: i번 행의 퀸은 col[i]번 열에 놓았다는 기록
	}
	
	static int n, ans;
	static int[] col;
	
	static boolean attackable(int r1, int c1, int r2, int c2) {
		if (c1 == c2) return true; 	// 같은 열에 있을 경우 공격 관계 성립
		if (r1-c1 == r2-c2) return true;	// 왼쪽 위 대각선에 존재 하므로 공격 관계 성립
		if (r1+c1 == r2+c2) return true;	// 오른쪽 위 대각선에 존재 하므로 공격 관계 성립
		return false;
	}
	
	static boolean validity_check() {
		for (int i=1; i<=n; i++) {
			// (i, col[i])
			for(int j=1; j<=i; j++) {
				// (j, col[j])
				if (attackable(i, col[i], j, col[j])) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// row 번 ~ n 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
	static void rec_func(int row) {
		if(row == n+1) {	// 각 행마다 잘 놓았다!
			ans++;
		} else {	// row번째 행에 모두 놓아보아야 하는 경우
			for(int c=1; c<=n; c++) {
				boolean possible = true;
				// valid check(row, c) 
				for (int i=1; i<=row-1; i++) {
					// (i, col[i])
					if (attackable(row, c, i, col[i])) {
						possible = false;
						break;
					}
				}
				if(possible) {	// (row,c)에 놓는 것이 이전에 놓았던 퀸들에 의해 공격받지 않는 위치라면 재귀 호출 시작
					col[row] = c;
					rec_func(row+1);
					col[row] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(ans);
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
