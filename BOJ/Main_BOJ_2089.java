import java.util.Scanner;

public class Main_BOJ_2089 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		if(N==0) {
			System.out.println(0);
		}
		else {
			StringBuffer sb=new StringBuffer();
			while(N!=1) {
				sb.append(Math.abs(N%(-2)));
				N=(int)Math.ceil((double)N/(-2));
			}
			
			sb.append(N);
			sb.reverse();
			System.out.println(sb);
		}
	}

}
