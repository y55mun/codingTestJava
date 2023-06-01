package practice;

import java.io.*;
import java.util.*;


public class c7_1260 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
	static int n, m, v;
	static int[][] adj;
	static boolean[] visit;
	
	static void input() {
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
		adj = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			int x = scan.nextInt(), y = scan.nextInt();
			adj[x][y] = adj[y][x] = 1;
		}
	}
	static void pro() {
		visit = new boolean[n+1];
		dfs(v);
		sb.append('\n');
		for (int i=1; i<=n; i++) visit[i] = false;
		bfs(v);
		System.out.println(sb);
	}

	
	
	public static void main(String[] args) {
		input();
		pro();
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
