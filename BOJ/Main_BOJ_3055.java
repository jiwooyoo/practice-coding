import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *   고슴도치는 물이 찰 예정인 칸으로 이동 불가  => 물 먼저 이동 시키고 고슴도치 이동  
 *   물과 고슴도치 각각 큐 따로 사용해야 함  
 */
public class Main_BOJ_3055 {

	static int R,C,time[][];
	static char[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean flag;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		time=new int[R][C];
		
		Queue<int[]> water=new LinkedList<>();
		Queue<int[]> go=new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			map[i]=br.readLine().toCharArray();
			Arrays.fill(time[i], Integer.MAX_VALUE);
		}
		
		// 큐에 집어넣을 때, 고슴도치면 go 물이면 water 으로 넣어서 구분 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='*') {
					water.offer(new int[] {i,j,0});
					time[i][j]=0;
				}
				else if(map[i][j]=='S') {
					go.offer(new int[] {i,j,0});
				}
			}
		}
		
		bfs(water);
		int num=move(go);
		System.out.println(num>0?num:"KAKTUS");
	}
	
	private static int move(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			int cnt=temp[2];
			
				for (int d = 0; d < 4; d++) {
					int nr=r+dr[d];
					int nc=c+dc[d];
					if(nr<0||nr>=R||nc<0||nc>=C) continue;
					if(map[nr][nc]=='D') return cnt+1;
					if(map[nr][nc]!='.') continue;
					if(time[nr][nc]>cnt+1) {  // 적힌 시간보다 작으면 이동 가능 
						map[nr][nc]='S';
						q.offer(new int[] {nr,nc,cnt+1});
					}
				}
		}
		return -1;
	}

	private static void bfs(Queue<int[]> q) {
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			int cnt=temp[2];
			
				for (int d = 0; d < 4; d++) {
					int nr=r+dr[d];
					int nc=c+dc[d];
					if(nr<0||nr>=R||nc<0||nc>=C||map[nr][nc]!='.') continue;
					if(time[nr][nc]>cnt+1) {
						time[nr][nc]=cnt+1;
						q.offer(new int[] {nr,nc,cnt+1});
					}
				}
		}
	}

}
