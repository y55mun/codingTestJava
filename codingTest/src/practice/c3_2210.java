package practice;

import java.util.*;
import java.io.*;

public class c3_2210 {
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		
		t = scan.nextInt();
		
		q = 25;		// 쿼터(Quarter, $0.25)
		d = 10;		// 다임(Dime, $0.10)
		n = 5;		// 니켈(Nickel, $0.05)
		p = 1;		// 페니(Penny, $0.01)
		
		for(int i=0; i<t; i++) {
			c = scan.nextInt();
			
			sb.append(c/q + " ");
			c %= q;
			
			sb.append(c/d + " ");
			c %= d;
			
			sb.append(c/n + " ");
			c %= n;
			
			sb.append(c/p + "\n");
			c %= p;
		}
		
		System.out.println(sb);
	}
	
	static int t, c, q, d, n, p;

	
	
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
			
		}
	}

}
