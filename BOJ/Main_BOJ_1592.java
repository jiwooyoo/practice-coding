import java.util.Scanner;

public class Main_BOJ_1592 {

	static int N,M,L;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		L=sc.nextInt();
		
		int[] p=new int[N];
		int ball=0;
		int tot=0;
		while(true) {
			p[ball]++;
			if(p[ball]==M) {
				break;
			}
			if(p[ball]%2==1) {
				ball=(ball+L)%N;
			}
			else {
				ball=(ball-L+N)%N;
			}
			tot++;
		}
		
		System.out.println(tot);
	}

}
