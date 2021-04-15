import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {

	static class Pipe{
		boolean[] dir=new boolean[4];
	}
	static int T,N,M,R,C,L;
	static int[][] arr,tunnel;
	static int[] dr= {-1,0,1,0};  // 상, 좌, 하, 우  
	static int[] dc= {0,-1,0,1};
	static Pipe[] pipe;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		pipe=new Pipe[8];
		for (int i = 0; i < 8; i++) {
			pipe[i]=new Pipe();
		}
		
		/*  각 터널 구조물 타입에 따른 방향 초기화   */ 
		for (int p = 0; p < 4; p++) {
			pipe[1].dir[p]=true;
		}
		pipe[2].dir[0]=true;
		pipe[2].dir[2]=true;
		
		pipe[3].dir[1]=true;
		pipe[3].dir[3]=true;
		
		pipe[4].dir[0]=true;
		pipe[4].dir[3]=true;
		
		pipe[5].dir[2]=true;
		pipe[5].dir[3]=true;
		
		pipe[6].dir[1]=true;
		pipe[6].dir[2]=true;
		
		pipe[7].dir[0]=true;
		pipe[7].dir[1]=true;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			
			arr=new int[N][M];
			visit=new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}

			escape();
			int tot=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visit[i][j]) tot++;
				}
			}
			System.out.println("#"+t+" "+tot);
		}
	}
	
	private static void escape() {   //  탈출하는  함수  
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {R,C,0});
		visit[R][C]=true;
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			int cnt=temp[2];
			int num=arr[r][c];
			if(cnt==L-1) break;    //  시간이 L 흐르면 빠져나가기(멈추기)   
			
			for (int d = 0; d < 4; d++) {
				if(!pipe[num].dir[d]) continue;   //갈 수 없으면 제외 
				int nr=r+dr[d];
				int nc=c+dc[d];
				int nd=(d+2)%4;
				if(nr<0||nc<0||nr>=N||nc>=M||visit[nr][nc]||arr[nr][nc]==0) continue;
				if(pipe[arr[nr][nc]].dir[nd]) {   //  다음칸의 파이프가 나와 이어져있으면  큐에 넣고 아니면 지나치기  
					visit[nr][nc]=true;
					q.offer(new int[] {nr,nc,cnt+1});
				}
			}
		}
	}

}
