import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251 {
	
	static class Road implements Comparable<Road>{
		int start;
		int end;
		double len;
		public Road(int start, int end, double len) {
			super();
			this.start = start;
			this.end = end;
			this.len = len;
		}
		
		@Override
		public int compareTo(Road o) {
			if(this.len>o.len) return 1;
			else return -1;
		}
		
	}
	static int T,N;
	static double E;
	static int[] X,Y,p,r;	
	static PriorityQueue<Road> pq=new PriorityQueue<>();
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N=Integer.parseInt(br.readLine());
			StringTokenizer st=null;
			X=new int[N];
			Y=new int[N];
			p=new int[N];
			r=new int[N];
			//for (int i = 0; i < 2; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					X[j]=Integer.parseInt(st.nextToken());
					p[j]=j;
				}
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					Y[j]=Integer.parseInt(st.nextToken());
					r[j]=1;
				}
		//	}
			E=Double.parseDouble(br.readLine());
			road();
			
			boolean[] v=new boolean[N];
			int cnt=0;
			double tot=0;
			while(!pq.isEmpty()) {
				Road road=pq.poll();
				int start=road.start;
				int end=road.end;
				double len=road.len;
				if(find(start)==find(end)) continue; //cycle 생김
				union(start,end); //그게 아니면 합치기
				tot+=E*len;
				cnt++;
			//	System.out.println(tot);
				if(cnt==N) {
					break;
				}
			}
			double res=Math.round(tot);
			
			System.out.printf("#%d %.0f\n",t,res);
		}
	}
	
	static void road() {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				double num=Math.pow(X[i]-X[j], 2.0)+Math.pow(Y[i]-Y[j], 2.0);
				pq.offer(new Road(j,i,num));
			}
		}
	}

	static int find(int x) {
		if(x==p[x]) return x;
		return p[x]=find(p[x]);
	}
	
	static void union(int x,int y) {
		int px=find(x);
		int py=find(y);
		if(px==py) return;
		
		if(r[px]<=r[py]) {
			p[px]=py;
			if(r[px]==r[py]) r[py]+=1;
		}
		else {
			p[py]=px;
		//	r[px]+=r[py];
		}
	}
}
