import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_10819 {
	static int N;
	static int[] p;
	static int[] num;
	static boolean[] selected;
	static int max;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		p=new int[N];
		num=new int[N];
		selected=new boolean[N];
		
		for (int i = 0; i < N; i++) {
			p[i]=sc.nextInt();
		}
		
		permutation(0);
		System.out.println(max);
	}
	
	static void permutation(int cnt) {
		if(cnt==N) {
			max=Math.max(max, sum());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(selected[i]) continue;
			selected[i]=true;
			num[cnt]=p[i];
			permutation(cnt+1);
			selected[i]=false;
		}
	}

	private static int sum() {
		int tot=0;
		for (int i = 0; i < N-1; i++) {
			tot+=Math.abs(num[i]-num[i+1]);
		}
		
		return tot;
	}
}
