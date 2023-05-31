package practice;

import java.util.*;
import java.io.*;

public class c6_4796 {

	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		caseNumber = 1;
		
		while(true) {
			l = Integer.parseInt(scan.next());
			p = Integer.parseInt(scan.next());
			v = Integer.parseInt(scan.next());
			
			if (l == 0 && p ==0 && v ==0) break;
			
			maxDays = (l*(v/p)) + (v%p);
			sb.append("Case "+caseNumber + ": "+maxDays+"\n");
			
			caseNumber++;
		}
		
		System.out.println(sb);
	}
	
	static int l, p, v, caseNumber, maxDays;
	
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
			while(st == null || !st.hasMoreElements()) {
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
