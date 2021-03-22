import java.util.Scanner;

public class Main_BOJ_14500 {

	static int N,M;
	static int[][] arr;
	static boolean[][] v;
	static int tot;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,-1,0,1};
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N][M];
		v=new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j]=true;
				termino(i,j,0,0);
				v[i][j]=false;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int small=1001;
				int sum=arr[i][j];
				int cnt=1;
				for (int k = 0; k < 4; k++) {
					if(i+dr[k]<0||i+dr[k]>=N||j+dc[k]<0||j+dc[k]>=M)
						continue;
					sum+=arr[i+dr[k]][j+dc[k]];
					cnt++;
					if(small>arr[i+dr[k]][j+dc[k]]) {
						small=arr[i+dr[k]][j+dc[k]];
					}
				}
				if(cnt<4) continue;
				if(cnt>4) sum-=small;
				if(tot<sum) {
					tot=sum;
				}
			}
		}
		
		System.out.println(tot);
	}
	
	public static void termino(int r,int c,int cnt,int sum) {
		if(cnt==4) {
			tot=Math.max(tot, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr<0||nr>=N||nc<0||nc>=M||v[nr][nc]) continue;
			v[nr][nc]=true;
			termino(nr,nc,cnt+1,sum+arr[r][c]);
			v[nr][nc]=false;
		}
	}

}
