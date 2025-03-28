import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static int[] wv;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int a=1; a<n+1; a++) {
			int b = Integer.parseInt(st.nextToken());
			if(b!=-1) {
				list[b].add(a);
			}
		}
		
		wv = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int man = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			wv[man] += w;
			
		}
		dfs(1);
		for(int i=1; i<n+1; i++) {
			System.out.print(wv[i]+" ");
		}
	}
	
	static void dfs(int idx) {
		for(int nxt : list[idx]) {
			wv[nxt] += wv[idx];
			dfs(nxt);
		}
	}
}
