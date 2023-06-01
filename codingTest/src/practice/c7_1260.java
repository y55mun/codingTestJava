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
	
	static void dfs(int x) {
		// x를 방문
		visit[x] = true;
		sb.append(x).append(' ');
		
		// x에서 갈 수 있는 곳들을 작은 번호부터 모두 방문한다.
		for(int y = 1; y<=n; y++) {
			if(adj[x][y] == 0) continue;
			
			// y를 이미 갈 수 있다는 사실을 알면, 굳이 갈 필요는 없다
			if(visit[y]) continue;
			
			// y에서 갈 수 있는 곳들 확인
			dfs(y);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		
		//start 는 방문 가능한 점 이므로 que 에 넣어줌
		que.add(start);
		visit[start] = true;	// start 를 갈 수 있다고 표시(중요)
		
		while(!que.isEmpty()) {
			int x = que.poll();
			
			sb.append(x).append(' ');
			for(int y=1; y<=n; y++) {
				if(adj[x][y] == 0) continue;
				if(visit[y]) continue;	// x에서 y를 갈 수는 있지만, 이미 탐색한 점이라면 무시
				
				// y를 갈 수 있으니 que 에 추가하고, visit 처리
				que.add(y);
				visit[y] = true;
			}
		}
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
