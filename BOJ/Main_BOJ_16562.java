import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16562 {

	static int N,M,K;
	static int[] friend,money;
	static int[] rank;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		friend=new int[N+1];
		money=new int[N+1];
		rank=new int[N+1];
		for (int i = 1; i <= N; i++) {
			friend[i]=i;
		}
		st=new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			money[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int tot=0;
		for (int i = 1; i <= N; i++) {
			if(money[i]==0) continue;
			tot+=money[i];
		}
		
		if(tot>K) {
			System.out.println("Oh no");
		}else {
			System.out.println(tot);
		}
	}
	
	static int find(int a) {
		if(a==friend[a]) return a;
		return friend[a]=find(friend[a]);
	}
	private static void union(int a, int b) {
		int pa=find(a);
		int pb=find(b);
		
		if(money[pa]>money[pb]) {
			friend[pa]=pb;
			money[pa]=0;
		}
		else {
			friend[pb]=pa;
			money[pb]=0;
		}
	}

}
