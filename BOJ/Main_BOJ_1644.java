import java.util.Scanner;

public class Main_BOJ_1644 {

	static int N;
	static boolean[] notprime;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		notprime=new boolean[N+1];
		
		notprime[0]=true;
		notprime[1]=true;
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N/i; j++) {
				if(!notprime[i*j]) {
					notprime[i*j]=true;
				}
			}
		}
		
		int res=0;
		int start=1,end=1;
		for (int i = 2; i <= N; i++) {
			int tot=0;
			int before=i;
			if(notprime[i]) continue;
			for (int j = i; j <= N; j++) {
			//	System.out.println(j+" "+notprime[j]);
				if(!notprime[j]) {
					tot+=j;
				//	System.out.println(i+" "+j+" "+tot);
					if(tot==N) {
				//		System.out.println("res "+res);
						res++;
						break;
					}
					else if(tot>N) {
						break;
					}
				}
				
			}
			
		}
		
		System.out.println(res);
	}

}
