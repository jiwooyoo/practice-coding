import java.util.Scanner;

public class Main_BOJ_14391 {
	
	static int N,M;
	static int[][] arr;
	static int[] dr= {1,0};
	static int[] dc= {0,1};
	static int tot;

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s=sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < (1<<(N*M)); i++) {
			int sum=0;
			
			//가로
			for (int j = 0; j < N; j++) {
				int num=0;
				for (int k = 0; k < M; k++) {
					int index=j*M+k;
					
					if((i&(1<<index))!=0) {
						sum+=num;
						num=0;
					}
					else {
						num=num*10+arr[j][k];
					}
				}
				sum+=num;
			}
			
			//세로
			for (int j = 0; j < M; j++) {
				int num=0;
				for (int k = 0; k < N; k++) {
					int index=k*M+j;
					
					if((i&(1<<index))!=0) {
						num=num*10+arr[k][j];
						
					}
					else {
						sum+=num;
						num=0;
					}
				}
				sum+=num;
			}
			
			tot=Math.max(tot, sum);
			
		}
		
		System.out.println(tot);
	}
	
}
