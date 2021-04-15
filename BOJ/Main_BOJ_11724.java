import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11724 {

	static int N,M;
	static int[] p;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		p=new int[N+1];
		for (int i = 0; i <= N; i++) {
			p[i]=i;
		}
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			union(start,end);
		}
		
		int cnt=0;
		for (int i = 1; i <= N; i++) {
			if(p[i]==i) cnt++;
		}
		
		System.out.println(cnt);
	}

	public static int find(int x) {
		if(x==p[x]) return x;
		return x=find(p[x]);
	}
	
	public static void union(int a, int b) {
		int pa=find(a);
		int pb=find(b);
		if(pa==pb) return;
		
		p[pb]=pa;
	}
}
