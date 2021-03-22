import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_15654 {
	static boolean[] v;
	static int N,M;
	static int[] num,arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		v=new boolean[N];
		num=new int[M];
		
		arr=new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		nPr(0);
	}

	private static void nPr(int cnt) {
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i]=true;
			num[cnt]=arr[i];
			nPr(cnt+1);
			v[i]=false;
		}
	}

}
