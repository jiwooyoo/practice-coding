import java.util.Scanner;

public class Solution_4014 {

	static int T,N,X;
	static int[][] ground;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			X=sc.nextInt();
			ground=new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ground[i][j]=sc.nextInt();
				}
			}
			
			int res=0;
			for (int i = 0; i < N; i++) {
				if(check(i,0,0)) {
					System.out.println(i+" "+0);
					res++;
				}
				if(check(0,i,1)) {
					System.out.println(0+" "+i);
					res++;
				}
			}
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	static int[] dr= {0,1};
	static int[] dc= {1,0};
	private static boolean check(int r, int c, int dir) {
		int current=ground[r][c];
		boolean flag=false;
		int cnt=0;
		for (int i = 1; i < N; i++) {
			int nr=r+dr[dir];
			int nc=c+dc[dir];
			int next=ground[nr][nc];
			cnt++;
			System.out.println(r+" "+c+" cnt : "+cnt);
			if(Math.abs(next-current)>1) return false;
			if(next==current) {
				if(flag&&cnt>=X) {
		//			System.out.println("GG");
					flag=false;
					cnt=0;
				}
				r=nr;
				c=nc;
			}
			else if(next==current+1){
				if(flag || cnt<X) {
		//			System.out.println("***"+cnt);
					return false;
				}
				cnt=0;
				current=next;
				r=nr;
				c=nc;
			}
			else if(next==current-1) {
				if(flag && cnt<X) {
					return false;
				}
				cnt=0;
				flag=true;
				current=next;
				r=nr;
				c=nc;
			}
			
			
			if(i==N-1) cnt++;
		}
		
		if(flag&&cnt<X) {
		//	System.out.println("here! cnt "+ cnt);
			return false;
		}
		return true;
	}

}
