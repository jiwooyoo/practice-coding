import java.util.Scanner;

public class Main_BOJ_2563 {

	static int[][] paper=new int[100][100];
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
				if(paper[i][j]==1)
					tot+=1;
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
