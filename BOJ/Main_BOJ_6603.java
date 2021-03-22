import java.util.Scanner;

public class Main_BOJ_6603 {
	static int T;
	static int[] lotto=new int[6];
	static int[] num;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			T=sc.nextInt();
			if(T==0) break;
			num=new int[T];
			
			for (int i = 0; i < T; i++) {
				num[i]=sc.nextInt();
			}
			
			comb(0,0);
			System.out.println();
		}
	}
	
	private static void comb(int cnt, int start) {
		if(cnt==6) {
			print();
			return;
		}
		
		for (int i = start; i < T; i++) {
			lotto[cnt]=num[i];
			comb(cnt+1,i+1);
		}
	}

	private static void print() {
		for (int i = 0; i < 6; i++) {
			System.out.print(lotto[i]+" ");
		}
		System.out.println();
	}

}
