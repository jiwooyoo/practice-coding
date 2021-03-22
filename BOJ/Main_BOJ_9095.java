import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_9095 {
	static int T,N;
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		T=sc.nextInt();
		p=new int[11];
		
		p[1]=1;
		p[2]=2;
		p[3]=4;
		for (int i = 4; i <= 10; i++) {
			p[i]=p[i-3]+p[i-2]+p[i-1];
		}
		
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			System.out.println(p[N]);
		}
		
	}
}
