import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1194 {

	static int N,M;
	static char[][] map;
	static boolean visit[][][];
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visit=new boolean[N][M][64];  //key 를 갖고 도달했을 때와 안갖고 도달했을 때 
		
		int sr=0,sc=0;
		for (int i = 0; i < N; i++) {
			map[i]=br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='0') {
					sr=i;
					sc=j;
				}
			}
		}
		
		System.out.println(bfs(sr,sc));
	}
	
	private static int bfs(int sr,int sc) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {sr,sc,0,0});
		visit[sr][sc][0]=true;
		int res=0;
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			int k=temp[2];
			int cnt=temp[3];
		//	System.out.println(r+" "+c+" "+k+" "+cnt);
			if(map[r][c]=='1') {
				res=cnt;
				return res;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M||map[nr][nc]=='#'||visit[nr][nc][k]) continue;
			//	visit[nr][nc][k]=true;
				int index=map[nr][nc]-'a';
				if(index>=0&&index<6) { // 소문자 (열쇠 )
					int tk=(1<<index)|k;  // 현재 열쇠를 비트화하여 방문처리 
					if(!visit[nr][nc][tk]) {
						visit[nr][nc][tk]=true;
						visit[nr][nc][k]=true;
						q.offer(new int[] {nr,nc,tk,cnt+1});
					}
				} else{
					index=map[nr][nc]-'A'; 
					if(index>=0&&index<6) {  // 대문자 (문인 경ㄱ우) 
						int door=(1<<index)&k;
						if(door>0) {  // & 연산 결과가 1이면 존재한다는 뜻 
							visit[nr][nc][k]=true;
							q.offer(new int[] {nr,nc,k,cnt+1});
						}
					}
					else {
						visit[nr][nc][k]=true;
						q.offer(new int[] {nr,nc,k,cnt+1});
					}
				}
			}
		}
		
		return -1;
	}

}
