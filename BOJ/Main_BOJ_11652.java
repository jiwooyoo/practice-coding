import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_11652 {

	static int N;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		long[] arr=new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextLong();
		}
		
		Arrays.sort(arr);
		int max=0;
		int tot=1;
		long num=arr[0];
		for (int i = 1; i < N; i++) {
			if(arr[i]==arr[i-1]) tot++;
			else {
				if(max<tot) {
					max=tot;
					num=arr[i-1];
				}
				tot=1;
			}
		}
		if(max<tot) {
			max=tot;
			num=arr[N-1];
		}
		
		System.out.println(num);
	}
	
}
