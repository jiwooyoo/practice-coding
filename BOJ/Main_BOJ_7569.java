import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7569 {

	static int M,N,T;
	static int[][][] tomato;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		Queue<int[]> q=new LinkedList<int[]>();
		tomato=new int[T][N][M];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				st=new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomato[i][j][k]=Integer.parseInt(st.nextToken());
					if(tomato[i][j][k]==1) q.offer(new int[] {i,j,k,0});
				}
			}
		}
		
		int h,r,c,cnt=0;
		int[] dh= {0,0,0,0,-1,1};
		int[] dr= {-1,1,0,0,0,0};
		int[] dc= {0,0,-1,1,0,0};
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			h=temp[0];
			r=temp[1];
			c=temp[2];
			cnt=temp[3];
			
			for (int d = 0; d < 6; d++) {
				int nh=h+dh[d];
				int nr=r+dr[d];
				int nc=c+dc[d];
				
				if(nh<0||nh>=T||nr<0||nr>=N||nc<0||nc>=M||tomato[nh][nr][nc]!=0) continue;
				tomato[nh][nr][nc]=1;
				q.offer(new int[] {nh,nr,nc,cnt+1});
			}
		}
		
		boolean check=true;
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(tomato[i][j][k]==0) {
						check=false;
						break;
					}
				}
			}
		}
		
		if(!check) cnt=-1;
		System.out.println(cnt);
	}

}
