import java.util.Scanner;

public class Main_BOJ_1244 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] sw=new int[N+1];
		for (int i = 1; i <= N; i++) {
			sw[i]=sc.nextInt();
		}
		int S=sc.nextInt();
		
		for (int i = 0; i < S; i++) {
			int gender=sc.nextInt();
			int num=sc.nextInt();
			if(gender==1) {
				for (int j = 1; j <= N; j++) {
					if(j%num==0) {
						sw[j]=(sw[j]+1)%2;
					}
				}
			}
			else {
				sw[num]=(sw[num]+1)%2;
				int n1=num-1;
				int n2=num+1;
				while(n1>=1&&n2<=N) {
					if(sw[n1]==sw[n2]) {
						sw[n1]=(sw[n1]+1)%2;
						sw[n2]=(sw[n2]+1)%2;
					}
					else break;
					n1--;
					n2++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(sw[i]+" ");
		}
		
	}

}
