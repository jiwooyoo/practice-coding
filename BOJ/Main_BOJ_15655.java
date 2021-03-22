import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_15655 {
	static int N,M;
	static int[] num,arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		num=new int[M];
		
		arr=new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		nCr(0,0);
	}

	private static void nCr(int cnt,int start) {
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			num[cnt]=arr[i];
			nCr(cnt+1,i+1);
		}
	}

}
