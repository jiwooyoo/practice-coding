import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17144 {

	static int R,C,T;
	static int[][] A;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		A=new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 1; i <= T; i++) {
			spread();
			clean();
		}
		
		int tot=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(A[i][j]==-1) continue;  //공기 청정기 칸 제외 
				tot+=A[i][j];
			}
		}
		System.out.println(tot);
	}
	
	public static void print() {    // 출력 확인용  
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void clean() {  //공기 청정기   
		int sr1=0;
		for (int i = 0; i < R; i++) {
			if(A[i][0]==-1) {
				sr1=i;
				break;
			}
		}
		int sr2=sr1+1;
		
		// 위에꺼
		int d=0;
		int r=sr1,c=0;
		while(true) {
		//	System.out.println("R "+r+" "+c);
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr<0||nr>sr1||nc<0||nc>=C) {
				d=(d+1)%4;
				nr=r+dr[d];
				nc=c+dc[d];
			}
			//System.out.println("nn "+nr+" "+nc);
			if(nr==sr1&&nc==0) {
			//	System.out.println("**"+nr+" "+nc);
				A[r][c]=0;
				A[nr][nc]=-1;
				break;
			}
			
			A[r][c]=A[nr][nc];
			r=nr;
			c=nc;
			
		}
		
		//아래꺼  
		d=2;
		r=sr2;
		c=0;
		while(true) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr<sr2||nr>=R||nc<0||nc>=C) {
				if(d==0) d=3;
				else d=(d-1);
				nr=r+dr[d];
				nc=c+dc[d];
			}
			
			if(nr==sr2&&nc==0) {
				A[r][c]=0;
				A[nr][nc]=-1;
				break;
			}
			
			A[r][c]=A[nr][nc];
			r=nr;
			c=nc;
		}
		
	}
	
	private static void spread() {   // 미세먼지 확산   
		Queue<int[]> q=new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(A[i][j]>0) q.offer(new int[] {i,j,A[i][j]});
			}
		}
		
		int r,c,num;
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			r=temp[0];
			c=temp[1];
			num=temp[2];
			
			int cnt=0;
			for (int d = 0; d < 4; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(nr<0||nr>=R||nc<0||nc>=C||A[nr][nc]==-1) continue;
				cnt++;
				A[nr][nc]+=num/5;
			}
			
			A[r][c]-=(num/5)*cnt;
		}
	}	

}
