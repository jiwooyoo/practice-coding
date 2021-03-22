import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_BOJ_1261 {

	static class Node {
		int r;  
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	
	}
	
	public static void main(String[] args) {

		int N,M;
		int[][] arr;
		int[] dr= {-1,1,0,0};
		int[] dc= {0,0,-1,1};
		boolean[][] visit;
		int[][] dist;
		Scanner sc=new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		arr=new int[N][M];
		dist=new int[N][M];
		visit=new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s=sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}

		Deque<Node> q=new LinkedList<>();
		q.addLast(new Node(0,0));  //r,c, 부순 벽의 개수
		visit[0][0]=true;
		
		while(!q.isEmpty()) {
			Node node=q.pollLast();
			int r=node.r;  
			int c=node.c;

			for (int i = 0; i < 4; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=M||visit[nr][nc]) continue;
			
				if(arr[nr][nc]==0) {
					dist[nr][nc]=dist[r][c];
					q.addLast(new Node(nr,nc));
				}
				else {
					dist[nr][nc]=dist[r][c]+1;
					q.addFirst(new Node(nr,nc));
				}
				visit[nr][nc]=true;
				
			}
		}
		
		System.out.println(dist[N-1][M-1]);
	}

}
