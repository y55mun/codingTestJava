package practice;

import java.io.*;
import java.util.*;

public class c1_11170 {
	
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		
		int cnt = 0;
		
		t = scan.nextInt();
		for (int i=0; i<t; i++) {
			n = scan.nextInt();
			m = scan.nextInt();
			
			System.out.println(solve(n, m));
		}

		selected = new int[m+1];
	}
	
	static int t, n, m;
	static int[] selected;
	

	static int solve(int n, int m) {
		int ret = 0;
		
		for (int i=n; i<=m; i++) {
			ret += calc(i);
		}
		return ret;
	}
	
	// 0 갯수 카운트
	static int calc(int num) {
		int ret = 0;
		for (char c: String.valueOf(num).toCharArray()) {
			if ( c == '0') {
				ret ++;
			}
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
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
			while (st == null || !st.hasMoreElements()) {
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
			String str ="";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
