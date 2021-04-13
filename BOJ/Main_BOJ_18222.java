import java.util.Scanner;

public class Main_BOJ_18222 {

	static long K;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		K=sc.nextLong();
		
		System.out.println(f(K-1));
	}

	static long f(long num) {
		if(num==0) return 0;
		
		if(num%2==0) {
			return f(num/2);
		}
		else {
			return f(num/2)^1;
		}
	}
}
