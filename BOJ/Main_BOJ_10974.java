import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_10974 {
	static int N;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		p=new int[N];
		for (int i = 0; i < N; i++) {
			p[i]=i+1;
		}
		
		do {
			for (int i = 0; i < N; i++) {
				System.out.print(p[i]+" ");
			}
			System.out.println();
		}while(np(p.length-1));
	}
	
	private static boolean np(int size) {
		int i=size;
		while(i>0 && p[i-1]>=p[i]) {
			i--;
		}
		if(i==0) return false;
		
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int temp=p[j];
		p[j]=p[i-1];
		p[i-1]=temp;
		
		int k=size;
		while(i<k) {
			temp=p[k];
			p[k]=p[i];
			p[i]=temp;
			i++;
			k--;
		}
		return true;
	}

}
