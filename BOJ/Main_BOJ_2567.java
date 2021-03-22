import java.util.Scanner;

/* 현재 위치가 1이면서
 * 주변이 0인 경우->둘레에 포함되는 변이라고 생각하면 됨
 * 사방향 중 0이 있는 개수만큼 유효 둘레(?)임
 */
public class Main_BOJ_2567 {
	static int[][] paper=new int[100][100];
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int r,c;
		for (int i = 0; i < n; i++) {
			r=sc.nextInt();
			c=sc.nextInt();
			color(r-1,c-1);
		}
		
		int tot=0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(paper[i][j]==1) {
					for (int k = 0; k < 4; k++) {
						int nr=i+dr[k];
						int nc=j+dc[k];
						if(nr>=0&&nc>=0&&nr<100&&nc<100&&paper[nr][nc]==0) {
							tot++;
						}
						else if(nr<0||nc<0||nr>=100||nc>100)  //이 부분 매우 중요!!!둘레가 벽면에 닿을 수도 있다는것!!!
							tot++;
					}
				}
			}
		}
		
		System.out.println(tot);
	}
	
	public static void color(int r,int c) {
		for (int i = r; i < r+10; i++) {
			for (int j = c; j < c+10; j++) {
				if(paper[i][j]!=1)
					paper[i][j]=1;
			}
		}
	}

}
