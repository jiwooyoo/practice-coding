import java.util.Scanner;

public class Main_BOJ_1463 {

	static int X;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		X=sc.nextInt();
		arr=new int[X+1];
		
		arr[1]=0;
		for (int i = 2; i <= X; i++) {
			int n1=Integer.MAX_VALUE;
			if(i%2==0) {
				n1=arr[i/2];
			}
			
			if(i%3==0) {
				n1=Math.min(n1, arr[i/3]);
			}
			
			n1=Math.min(n1, arr[i-1]);
			
			arr[i]=n1+1;
		}
		
		System.out.println(arr[X]);
	}

}
