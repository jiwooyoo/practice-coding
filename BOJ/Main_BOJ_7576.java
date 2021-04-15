import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576 {

	static int M,N;
	static int[][] tomato;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		tomato=new int[N][M];
		
		Queue<int[]> q=new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j]=Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1) {
					q.offer(new int[] {i,j,0});
				}
			}
		}
		
		int r,c,cnt=0;
		int[] dr= {-1,1,0,0};
		int[] dc= {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			r=temp[0];
			c=temp[1];
			cnt=temp[2];
			
			for (int d = 0; d < 4; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(nr<0||nr>=N||nc<0||nc>=M||tomato[nr][nc]!=0) continue;
				tomato[nr][nc]=1;
				q.offer(new int[] {nr,nc,cnt+1});
			}
		}
		
		boolean check=false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j]==0) {
					check=true;
					break;
				}
			}
		}
		
		if(check) cnt=-1;
		System.out.println(cnt);
	}

}
