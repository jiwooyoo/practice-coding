package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1863 {

	static int n,m;
	static int[] p;
	static int[] R;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		p=new int[n+1];
		R=new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i]=i;
			//R[i]=1;
		}
		
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int cnt=0;
		for (int i = 1; i <= n; i++) {
			if(i==p[i]) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static int find(int a) {
		if(a==p[a]) return a;
		return p[a]=find(p[a]);
	}
	
	private static void union(int a, int b) {
		int rootA=find(a);
		int rootB=find(b);
	//	if(rootA==rootB) return;
		
		if(R[rootA]>R[rootB]) {
			p[rootB]=rootA;
		}else {
			p[rootA]=rootB;
			if(R[rootA]==R[rootB]) {
				R[rootB]++;
			}
		}
		
	}

}
