package brute_force;

import java.io.*;
import java.util.*;

public class c5_14888 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	
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
	
	static void input() {
		n = scan.nextInt();
		nums = new int[n+1];
		operators = new int[5];
		for (int i=1; i<=n; i++) nums[i] = scan.nextInt();
		for (int i=1; i<=4; i++) operators[i] = scan.nextInt();
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
	
	static int n, max, min;
	static int[] nums, operators;
	
	static int calculator(int operand1, int operator, int operand2) {
		if (operator == 1) // +
			return operand1 + operand2;
		else if (operator == 2) // -
			return operand1 - operand2;
		else if (operator == 3) // *
			return operand1 * operand2;
		else
			return operand1 / operand2;
		
	}
	
	
	// order[1...n-1] 에 연산자들이 순서대로 저장
	static void rec_func(int k, int value) {
		if (k==n) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {	// k번째 연산자를 무엇으로 할 것인지
			for (int cand = 1; cand<=4; cand++) {
				if(operators[cand] >= 1) {
					operators[cand]--;
					rec_func(k+1, calculator(value, cand, nums[k+1]));
					operators[cand]++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		rec_func(1, nums[1]);
		sb.append(max).append('\n').append(min);
		System.out.println(sb.toString());
		
	}

}
