import java.util.Scanner;

public class Main_BOJ_8320 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int tot=0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if(i*j>N) {
					break;
				}
				tot++;
			}
		}
		
		System.out.println(tot);
	}

}
