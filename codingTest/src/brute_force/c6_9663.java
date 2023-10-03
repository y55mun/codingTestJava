package brute_force;

import java.io.*;
import java.util.*;

public class c6_9663 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		n = scan.nextInt();
		col = new int[n+1];
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
	
	static void rec_func(int row) {
		if(row == n+1) {
			if(validity_check()) {
				ans++;
			}
		} else {
			for(int c=1; c<=n; c++) {
				col[row] = c;
				rec_func(row+1);
				col[row] = 0;
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
