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
	
	// k번째 원소를 포함시킬지 정하는 함수
	// value: ~ k-1 번째 원소까지 골라진 원소들의 합
	static void rec_func(int k, int value) {
		if(k == n+1) {	// 부분 수열을 하나 완성 시킨 상태
			if(value == s) ans++;	// value 가 s 와 같은지 확인
		} else {
			// k번째 원소를 포함 시키고 싶은 경우
			rec_func(k+1, value+nums[k]);
			
			// k번째 원소를 포함 시키지 않은 경우
			rec_func(k+1, value);
		}
	}
	
	public static void main(String[] args) {
		input();
		rec_func(1, 0);
		
		// ans 가 정말 "진 부분집합" (비어있지 않은 집합)만 다루는지 확인!!!!
		// s가 0일 경우 즉, 목표하는 값이 0 일 경우 아무것도 안골라도 ans가 증가하는 경우가 생김
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
