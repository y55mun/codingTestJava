package codingTest;

import java.io.*;
import java.util.*;

public class c2_15649 {

	static StringBuilder sb = new StringBuilder();

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M + 1];
	}

	static int N, M;
	static int[] selected, used;

	// 만약 M개를 전부 고름 => 조건에 맞는 탐색 한가지 성공
	// 아직 M개를 고르지 않음 => K번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도
	static void rec_func(int k) {
		if (k == M + 1) { // 1 ~ M번째는 전부 다 고른 경우
			// selected[1 ~ M] 배열이 새롭게 탐색된 결과
			for (int i = 1; i <= M; i++)
				sb.append(selected[i]).append(' ');
			sb.append('\n');
		} else {
			for (int cand = 1; cand <= N; cand++) {
				if (used[cand] == 1) continue;
				
				selected[k] = cand; used[cand] = 1;
				
				rec_func(k + 1);
				
				selected[k] = 0; used[cand] = 0;
				
//				boolean isUsed = false;
//				for (int i = 1; i < k; i++)
//					if (cand == selected[i])
//						isUsed = true;
//				if (!isUsed) {
//					selected[k] = cand;
//					rec_func(k + 1);
//					selected[k] = 0;
//				}

			}
		}
	}

	public static void main(String[] args) {
		input();

		rec_func(1);
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
