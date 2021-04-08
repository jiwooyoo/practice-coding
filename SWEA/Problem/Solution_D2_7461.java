import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D2_7461 {

	static int T;
	static int N,K;
	static int[] dp;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			K=sc.nextInt();
			
			int res=1;
			for (int i = 2; i <= N; i++) {
				res=(res+K-1)%i+1;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
