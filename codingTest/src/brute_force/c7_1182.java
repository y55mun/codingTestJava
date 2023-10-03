package brute_force;

import java.io.*;
import java.util.*;

public class c7_1182 {
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		n = scan.nextInt();
		s = scan.nextInt();
		nums = new int[n+1];
		for (int i=1; i<=n; i++) nums[i] = scan.nextInt();
	}
	
	static int n, s, ans;
	static int[] nums;
	
	static void rec_func(int k, int value) {
		if(k == n+1) {
			if(value == s) ans++;
		} else {
			rec_func(k+1, value+nums[k]);
			rec_func(k+1, value);
		}
	}
	
	public static void main(String[] args) {
		input();
		rec_func(1, 0);
		
		if (s == 0) {
			ans--;
		}
		
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
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
