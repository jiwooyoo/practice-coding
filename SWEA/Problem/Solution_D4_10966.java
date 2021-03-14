import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_10966 {

	static int T,N,M;
	static char[][] arr;
	static boolean[][] v;
	static int tot;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,-1,0,1};
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tot=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			arr=new char[N][M];
			v=new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				String s=br.readLine();
				arr[i]=s.toCharArray();
			}
			
			Queue<int[]> q=new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]=='W') {
						v[i][j]=true;
						q.offer(new int[] {i,j,0});
					}
				}
			}
			
			while(!q.isEmpty()) {
				int[] temp=q.poll();
				int r=temp[0];
				int c=temp[1];
				int cnt=temp[2];
				
				for (int i = 0; i < 4; i++) {
					int nr=r+dr[i];
					int nc=c+dc[i];
					if(nr<0||nc<0||nr>=N||nc>=M||v[nr][nc]) continue;
					if(arr[nr][nc]=='W') continue;
					v[nr][nc]=true;
					tot+=(cnt+1);
					q.offer(new int[] {nr,nc,cnt+1});
				}
			}
			
			System.out.println("#"+t+" "+tot);
		}
	}
	
	
}
