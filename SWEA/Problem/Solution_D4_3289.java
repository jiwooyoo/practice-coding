package algo0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289 {

	static int T,n,m;
	static int[] p;
	static int[] R;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			p=new int[n+1];
			R=new int[n+1];
			for (int i = 1; i <= n; i++) {
				p[i]=i;
			}
			
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < m; i++) {
				st=new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				if(num==0) {
					union(a,b);
				}else {
					if(isSame(a,b)) sb.append(1);
					else sb.append(0);
				}
			}
			
			System.out.println("#"+t+" "+sb);
		}
		
		
	}
	private static boolean isSame(int a, int b) {
		return find(a)==find(b);
	}
	
	private static void union(int a, int b) {
		int pa=find(a);
		int pb=find(b);
		if(pa==pb) {
			return; //이미 같은 집합
		}
		
		p[pb]=pa;
	}
	
	private static int find(int x) {
		if(x==p[x]) return x;
		return p[x]=find(p[x]);
	}

}
