import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_5656 {

	static int T,N,W,H;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean[][] v;
	//static int[][] arr;
	static int res;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			W=sc.nextInt();
			H=sc.nextInt();
			res=Integer.MAX_VALUE;
			
			int[][] arr=new int[H+1][W];
			int[][] A=new int[H+1][W];
			int[][] brick=new int[H+1][W];
			for (int i = 1; i <= H; i++) {
				for (int j = 0; j < W; j++) {
					A[i][j]=sc.nextInt();
				}
			}
			/*			print(A);
			for (int i = 0; i < W; i++) {
				A[H-1][i]=0;
			}
			move(A);
			print(A);*/
		
			for (int j = 0; j < W; j++) {
				init(arr,A);
				int i=0;
				while(i<=H && arr[i][j]==0) i++;
				if(i==H+1) continue;
				bfs(i,j,arr,0);	
				if(res==0) break;
			}			
			
			System.out.println("#"+t+" "+res); 
			
		}
	}
	
	static void print(int[][] a) {
		for (int i = 1; i <= H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	
	static void move(int[][] a) {
		for (int j = 0; j < W; j++) {
			for (int i = H; i > 1; i--) {
				if(a[i][j]==0) {
					int index=i;
					while(index>1&& a[index][j]==0) index--;
					a[i][j]=a[index][j];
					a[index][j]=0;
				}
			}
		}
	}
	
	static void init(int[][] a,int[][] b) {
		for (int i = 1; i <= H; i++) {
			for (int j = 0; j < W; j++) {
				a[i][j]=b[i][j];
			}
		}
	}
	
	static boolean check(int[][] a) {
		int tot=0;
		for (int i = 1; i <= H; i++) {
			for (int j = 0; j < W; j++) {
				if(a[i][j]!=0) tot++;
			}
		}
		
		if(tot==0) return true;
		else return false;
	}
	
	static void bfs(int sr, int sc,int[][] arr, int cnt) {
		if(cnt==N) {
			int tot=0;
			for (int i = 1; i <= H; i++) {
				for (int j = 0; j < W; j++) {
					if(arr[i][j]!=0) tot++;
				}
			}
			if(res>tot) {
				res=tot;
			//	print(arr);
			}
			return;
		}
		
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {sr,sc,arr[sr][sc]});
		v=new boolean[H+1][W];
		v[sr][sc]=true;
		arr[sr][sc]=0;
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			int num=temp[2]; //arr[r][c];
			//arr[r][c]=0;
			
			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < num; i++) {
				//	System.out.println("here");
					int nr=r+dr[d]*i;
					int nc=c+dc[d]*i;
					if(nr<1||nc<0||nr>=H+1||nc>=W||v[nr][nc]||arr[nr][nc]==0) continue;
					v[nr][nc]=true;
					q.offer(new int[] {nr,nc,arr[nr][nc]});
					arr[nr][nc]=0;
				}
			}
		}
		
	//	print(arr);
		if(check(arr)) {
			res=0;
			return;
		}
		
		move(arr);
		int[][] A=new int[H+1][W];
		
		for (int j = 0; j < W; j++) {
			init(A,arr);
			int i=0;
			while(i<H+1 && A[i][j]==0) i++;
			if(i==H+1) {
				continue;
			}
			bfs(i,j,A,cnt+1);
		}
		
		
	}

}
