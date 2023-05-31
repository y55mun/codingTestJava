package practice;

import java.util.*;
import java.io.*;

public class c4_10162 {

	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		
		t = scan.nextInt();
		
		a = 300;	// 5분
		b = 60;		// 1분
		c = 10;		// 10초
		
		sb.append(t/a + " ");
		t %= a;
		
		sb.append(t/b + " ");
		t %= b;

		sb.append(t/c + " ");
		t %= c;
		
		if ( t != 0 ) {
			System.out.println("-1");
		}
		else {
			System.out.println(sb);
		}
		
	}
	
	static int t, a, b, c;
	
	public static void main(String[] args) {
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
				} catch (IOException e) {
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
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
	}
}
