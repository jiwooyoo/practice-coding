import java.util.Scanner;

public class Main_BOJ_1182 {

	static int N,S;
	static int[] arr;
	static int tot;
	static boolean[] v;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		S=sc.nextInt();
		arr=new int[N];
		v=new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		power(0,0);
		System.out.println(tot);
	}
	
	private static void power(int cnt, int sum) {
		if(cnt==N) {
			
			if(sum==S) {
				int total=0;
				for (int i = 0; i < N; i++) {
					if(v[i]==false) total++;
				}
				if(total==N) return;
				else tot++;
			}
			return;
		}
		
		v[cnt]=true;
		power(cnt+1,sum+arr[cnt]);
		v[cnt]=false;
		power(cnt+1,sum);
	}

}
