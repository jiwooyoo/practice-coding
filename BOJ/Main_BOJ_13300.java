import java.util.Scanner;

public class Main_BOJ_13300 {

	static int N,K;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		int S,Y;
		int[] Girl=new int[7];
		int[] Boy=new int[7];
		
		for (int i = 0; i < N; i++) {
			S=sc.nextInt();
			Y=sc.nextInt();
			
			if(S==0) {
				Girl[Y]++;
			}
			else {
				Boy[Y]++;
			}
		}
		
		int cnt=0;
		for (int i = 1; i < 7; i++) {
			if(Girl[i]!=0) {
				if(Girl[i]%K==0) {
					cnt+=Girl[i]/K;
				}
				else cnt+=(Girl[i]/K+1);
			}
			if(Boy[i]!=0) {
				if(Boy[i]%K==0) {
					cnt+=Boy[i]/K;
				}
				else cnt+=(Boy[i]/K+1);
			}
		}
		
		System.out.println(cnt);
	}

}
