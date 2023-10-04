package brute_force;

import java.io.*;
import java.util.*;

public class c8_6603 {
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();
		
		while(true) {
			k = scan.nextInt();
			if (k == 0) break;
			num = new int[k+1];
			selected = new boolean[k+1];
			
			for(int i=1; i<=k; i++) {
				num[i] = scan.nextInt();
			}
			
			sb.append('\n');
			rec_func(0, 1);
			
		}
	}

	static int k;
	static int[] num;
	static boolean[] selected;
	
	static void rec_func(int depth, int start) {
	
		if(depth == 6) {
			for (int i=1; i<=k; i++) {
				if (selected[i])	sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<=k; i++) {
			if (!selected[i]) {
				selected[i] = true;
				rec_func(depth+1, i+1);
				selected[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		input();
		System.out.println(sb.toString());
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
