import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_17086 {

	static int N,M;
	static int[][] shark;
	static int[] dr= {-1,-1,-1,0,0,1,1,1};
	static int[] dc= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		shark=new int[N][M];
		
		Queue<int[]> q=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				shark[i][j]=sc.nextInt();
				if(shark[i][j]==1) {
					q.offer(new int[] {i,j,0});
				}
			}
		}
		
		int max=0;
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			int cnt=temp[2];
			if(max<cnt) max=cnt;
			
			for (int i = 0; i < 8; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=M||shark[nr][nc]!=0) continue;
				shark[nr][nc]=cnt+1;
				q.offer(new int[] {nr,nc,cnt+1});
			}
		}
		System.out.println(max);
	}

}
