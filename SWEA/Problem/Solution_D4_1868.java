import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1868 {

	static int N,num[][];
	static char[][] arr;
	static int res;
	static int[] dr= {-1,-1,-1,0,0,1,1,1};
	static int[] dc= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N=Integer.parseInt(br.readLine());
			arr=new char[N][N];
			num=new int[N][N];
			
			for (int i = 0; i < N; i++) {
				arr[i]=br.readLine().toCharArray();
			}
			
			res=0;
			setNum();
			// 0 인 애들 먼저 다 제거 해주기 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(num[i][j]==0&&arr[i][j]=='.') {  // 아직 방문 안했으면서 0인 것! 
						popping(i,j);
						res++;
					}
				}
			}
			// 0 아닌 애들 제거(남은 애들) 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]=='.') {  // 아직 방문 안한 애들은 어차피 하나씩 터지므로 
						res++;       // 갯수만 세어주면 횟수가 된다. 
					}
				}
			}
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void setNum() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(arr[r][c]=='*') {
					num[r][c]=-1;
					continue;
				}
				int cnt=0;
				for (int d = 0; d < 8; d++) {
					int nr=r+dr[d];
					int nc=c+dc[d];
					if(nr<0||nc<0||nr>=N||nc>=N||arr[nr][nc]=='.') continue;
					cnt++;
				}
				num[r][c]=cnt;
			}
		}
	}

	private static void popping(int sr,int sc) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {sr,sc});
		arr[sr][sc]='*';
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int r=temp[0];
			int c=temp[1];
			
			for (int d = 0; d < 8; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(nr<0||nc<0||nr>=N||nc>=N||arr[nr][nc]=='*') continue;
				if(num[nr][nc]==0) q.offer(new int[] {nr,nc});  // 숫자가 0인 애들은 인접까지 다 터트리므로 큐에 넣어주기  
				arr[nr][nc]='*';   // 방문흔적을 *로 표시 처리 
			}
		}
		
	}

}
