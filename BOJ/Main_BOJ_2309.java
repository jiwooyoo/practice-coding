import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2309 {

	static int N=9;
	static int R=7;
	static int[] dwarf,res;
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		dwarf=new int[N];
		res=new int[R];
		for (int i = 0; i < N; i++) {
			dwarf[i]=sc.nextInt();
		}
		
		comb(0,0);
		
	}

	private static void comb(int cnt, int start) {
		if(cnt==R) {
			int sum=0;
			for (int i = 0; i < R; i++) {
				sum+=res[i];
			}
			if(sum==100) {
				Arrays.sort(res);
				for (int i = 0; i < R; i++) {
					System.out.println(res[i]);
				}
				System.exit(0);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			res[cnt]=dwarf[i];
			comb(cnt+1,i+1);
		}
	}
	
}
