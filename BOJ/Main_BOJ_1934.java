import java.util.Scanner;

public class Main_BOJ_1934 {

	static int T;
	static int A,B;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 0; t < T; t++) {
			A=sc.nextInt();
			B=sc.nextInt();
			if(B>A) {
				int temp=A;
				A=B;
				B=temp;
			}
			
			int a=A,b=B;
			while(b!=0) {
				int temp=a%b;
				a=b;
				b=temp;
			}
			
			System.out.println((A*B)/a);
		}
	}

}
