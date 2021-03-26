import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//MST 이용 ( 크루스칼 알고리즘 )
//문제 중요 조건 : 다리 길이 2 이상, 방향 틀기 없음
public class Main_BOJ_17472 {

	static class Graph implements Comparable<Graph>{
		int start;
		int end;
		int dist;
		public Graph(int start, int end, int dist) {
			super();
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Graph o) {
			return this.dist-o.dist;
		}
		
	}
	
	static int N,M;
	static int[][] arr;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int num=1; //전체 섬 수
	static int[] p,r;  //p : 속한 집합의 대표 , r: 각 집합의 높이
	static PriorityQueue<Graph> pq=new PriorityQueue<>();
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		//섬 별로 번호로 초기화
		init();
	//	print();
		//섬간의 다리 길이 구하기
		getLength();
		//MST 진행
		p=new int[num];
		r=new int[num];
		for (int i = 0; i < num; i++) {
			p[i]=i;
			r[i]=1;
		}
		
		MST();
	}
	
	static void print() {  //출력용 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void MST() {
		int tot=0,cnt=0;
		while(!pq.isEmpty()) {
			Graph g=pq.poll();
			int start=g.start;
			int end=g.end;
			int dist=g.dist;
			if(dist<=1) continue;
			if(find(start)==find(end)) continue;
			union(start,end);
			tot+=dist;
			cnt++;
			if(cnt==num-2) {
				break;
			}
		}
		
		int a=0;
		for (int i = 1; i < num; i++) {
			if(p[i]==i) a++;
		}
		
		if(a!=1) System.out.println(-1);
		else System.out.println(tot);
	}

	private static void init() {
		boolean[][] v=new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==1&&!v[i][j]) {
					Queue<int[]> q=new LinkedList<>();
					q.offer(new int[] {i,j});
					v[i][j]=true;
					while(!q.isEmpty()) {
						int[] temp=q.poll();
						int r=temp[0];
						int c=temp[1];
						arr[r][c]=num;
						
						for (int d = 0; d < 4; d++) {
							int nr=r+dr[d];
							int nc=c+dc[d];
							if(nr<0||nc<0||nr>=N||nc>=M||v[nr][nc]||arr[nr][nc]==0) continue;
							v[nr][nc]=true;
							q.offer(new int[] {nr,nc});
						}
					}
					num++;
				}
			}
		}
	}
	
	private static void getLength() {
		boolean[][] check=new boolean[num+1][num+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]!=0) {
					int currentNum=arr[i][j];  //현재 위치의 섬의 번호
					
					for (int d = 0; d < 4; d++) {  //한 방향별로 끝까지 가보기
						int sr=i;
						int sc=j;
						int r=i;
						int c=j;
						while(true) {
							r+=dr[d];
							c+=dc[d];
							if(r<0||c<0||r>=N||c>=M) break;
							
							if(arr[r][c]==currentNum) {
								break;
							}
							if(arr[r][c]!=0) {
								int dist=Math.abs(r-sr)+Math.abs(c-sc)-1;
								pq.add(new Graph(currentNum,arr[r][c],dist));
								break;
							}
						}
					}
				}
			}
		}
	}  //getLength 함수 끝
	
	static int find(int x) {
		if(x==p[x]) return x;
		return p[x]=find(p[x]);
	}
	
	static void union(int x,int y) {
		int px=find(x);
		int py=find(y);
		if(px==py) return;
		
		if(r[px]>=r[py]) {
			r[px]+=r[py];
			p[py]=px;
		}
		else {
			r[py]+=r[px];
			p[px]=py;
		}
	}
}
