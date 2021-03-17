import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_14889 {

	static int N;
	static int[][] S;
	static int[] p;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		S=new int[N][N];
		p=new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				S[i][j]=sc.nextInt();
			}
		}
		
		for (int i = N/2; i < N; i++) {
			p[i]=1;
		}
		
		int min=Integer.MAX_VALUE;
		do {
			int A=0,B=0;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if(p[i]!=p[j]) continue;
					if(p[i]==0) {
						A+=(S[i][j]+S[j][i]);
					}
					else {
						B+=(S[i][j]+S[j][i]);
					}
				}
			}
			min=Math.min(min, Math.abs(A-B));
			
		}while(np(p.length-1));
		
		System.out.println(min);
	}
	
	private static boolean np(int size) {
		int i=size;
		while(i>0 && p[i-1]>=p[i]) i--;
		if(i==0) return false;
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int temp=p[j];
		p[j]=p[i-1];
		p[i-1]=temp;
		int k=size;
		while(i<k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		return true;
	}

}
