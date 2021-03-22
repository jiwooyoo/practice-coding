import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_2636 {

	static int N,M;
	static int[][] cheese;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean[][] v;
	static int totC;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		cheese=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cheese[i][j]=sc.nextInt();
				if(cheese[i][j]==1) {
					totC++;
				}
			}
		}
		
		int cnt=0;
		int time=0;
		while(totC!=0) {
			time++;
			cnt=totC;
			melt();
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	private static void melt() {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {0,0});
		v=new boolean[N][M];
		v[0][0]=true;
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			
			for (int i = 0; i < 4; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=M||v[nr][nc]) continue;
				if(cheese[nr][nc]==0) q.offer(new int[] {nr,nc});
				else {
					cheese[nr][nc]=0;
					totC--;
				}
				v[nr][nc]=true;
			}
		}
	}
}
