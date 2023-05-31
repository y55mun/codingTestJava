package practice;

import java.util.*;
import java.io.*;

public class c5_5585 {

	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		
		n = scan.nextInt();
		
		// 잔돈의 종류
		a = 500;
		b = 100;
		c = 50;
		d = 10;
		e = 5;
		f = 1;
		
		// 잔돈에 포함된 매수
		cnt = 0;

		n = 1000 - n;
		
		if (n / a != 0) {
			cnt += (n / a);
			n %= a;
		}
		if( (n / b) != 0) {
			cnt += n / b;
			n %= b;
		}
		if( (n / c) != 0) {
			cnt += n / c;
			n %= c;
		}
		if( (n / d) != 0) {
			cnt += n / d;
			n %= d;
		}
		if( (n / e) != 0) {
			cnt += n / e;
			n %= e;
		}
		if( (n / f) != 0) {
			cnt += n / f;
			n %= f;
		}
		
		System.out.println(cnt);
		
	}
	
	
	static int n, a, b, c, d, e, f, cnt;
	
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
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			return str;
		}
		
	}
}
