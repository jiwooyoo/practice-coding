import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2564 {
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr;
		int N=sc.nextInt();
		int M=sc.nextInt();
		int T=sc.nextInt();
		
		arr=new int[T+1];	
		
		int r,c;
		for (int i = 0; i <= T; i++) {
			r=sc.nextInt();
			c=sc.nextInt();
			if(r==1) {  //북쪽
				arr[i]=c;
			}
			else if(r==2) {  //남쪽
				arr[i]=2*N+M-c;
			}
			else if(r==3) { //서쪽
				arr[i]=2*(M+N)-c;
			}
			else {
				arr[i]=N+c;
			}
		}
		
		int tot=0;
		int half=M+N;
		for (int i = 0; i < T; i++) {
			if(Math.abs(arr[T]-arr[i])>half) {
				tot+=(2*half-Math.abs(arr[T]-arr[i]));
			}
			else {
				tot+=Math.abs(arr[T]-arr[i]);
			}
		}
		
		System.out.println(tot);
		
	}

}
