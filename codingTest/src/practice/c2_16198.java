package practice;

import java.io.*;
import java.util.*;


public class c2_16198 {

	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		FastReader scan = new FastReader();

		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(scan.nextInt());
		}
		
		dfs(list, 0);
		System.out.println(max);
		
	}
	
	static void dfs(List<Integer> list, int sum) {
		if(list.size() == 2) {
			max = Math.max(max, sum);
			return;
		}
		for (int i=1; i<list.size()-1; i++) {
			int temp = list.get(i);
			int num = list.get(i-1) * list.get(i+1);
			list.remove(i);
			
			dfs(list, sum+num);
			list.add(i, temp);	// dfs 종료 후 빼낸 정보 넣기
		}
	}
	
	
	static int n, max = Integer.MIN_VALUE;
	
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
	}
	

}
