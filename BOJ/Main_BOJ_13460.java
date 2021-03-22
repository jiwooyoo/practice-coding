import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_13460 {

	static class Node{
		int rr;
		int rc;
		int br;
		int bc;
		int cnt;
		
		public Node() {
			super();
			this.cnt=0;
		}
		public Node(int rr, int rc, int br, int bc, int cnt) {
			super();
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
			this.cnt = cnt;
		}
		
	}
	
	static int N,M;
	static int[] dr= {-1,0,1,0};  //북서남동
	static int[] dc= {0,-1,0,1};
	static char[][] arr;
	static boolean[][][][] v;
	static int or,oc;
	static int tot=Integer.MAX_VALUE;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new char[N][M];
		v=new boolean[10][10][10][10];
		
		Node node=new Node();
		
		for (int i = 0; i < N; i++) {
			String s=sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j]=s.charAt(j);
				if(arr[i][j]=='B') {
					node.br=i;
					node.bc=j;
				}
				else if(arr[i][j]=='R') {
					node.rr=i;
					node.rc=j;
				}
			}
		}
		
		bfs(node);
	}
	
	private static void bfs(Node bead) {
		Queue<Node> q=new LinkedList<>();
		q.offer(bead);
		
		while(!q.isEmpty()) {
			Node node=q.poll();
			v[node.rr][node.rc][node.br][node.bc]=true;
			
			if(node.cnt>=10) {
				System.out.println(-1);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nbr=node.br;
				int nbc=node.bc;
				while(arr[nbr+dr[i]][nbc+dc[i]]!='#') {
					nbr+=dr[i];
					nbc+=dc[i];
					if(arr[nbr][nbc]=='O') {
						break; //파란색이 빠지면 무조건 게임끝
					}
					
				}
				
				int nrr=node.rr;
				int nrc=node.rc;
				while(arr[nrr+dr[i]][nrc+dc[i]]!='#') {
					nrr+=dr[i];
					nrc+=dc[i];
					if(arr[nrr][nrc]=='O') {
						break;
					}
					
				}
				
				if(arr[nbr][nbc]=='O') continue;
				if(arr[nrr][nrc]=='O') {
					System.out.println(node.cnt+1);
					return;
				}
				
				//이동 후 두 구슬의 위치가 같은 경우 선위치 파악 후 조정
				if(nbr==nrr&&nbc==nrc) {
					switch(i) { //북서남동
					case 0:  //북
						if(node.br>node.rr) {
							nbr+=1;
						}
						else nrr+=1;
						break;
					case 1:  //서
						if(node.bc>node.rc) {
							nbc+=1;
						}
						else {
							nrc+=1;
						}
						break;
					case 2:  //남
						if(node.br>node.rr) {
							nrr-=1;
						}
						else nbr-=1;
						break;
					case 3:  //동
						if(node.bc>node.rc) {
							nrc-=1;
						}
						else {
							nbc-=1;
						}
						break;
					}
				}
				
				if(!v[nrr][nrc][nbr][nbc]) {
					q.offer(new Node(nrr,nrc,nbr,nbc,node.cnt+1));
				}
			}
			
		}
		
		System.out.println(-1);
	}
	
}
