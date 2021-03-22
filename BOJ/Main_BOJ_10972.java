import java.util.Scanner;

public class Main_BOJ_10972 {
	static int N;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		p=new int[N];
		for (int i = 0; i < N; i++) {
			p[i]=sc.nextInt();
		}
		
		if(np(p.length-1)) {
			for (int i = 0; i < N; i++) {
				System.out.print(p[i]+" ");
			}
		}
		else {
			System.out.println("-1");
		}
	}
	
	private static boolean np(int size) {
		int i=size;
		while(i>0&&p[i-1]>=p[i]) {
			i--;
		}
		if(i==0) return false;
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int tmp=p[j];
		p[j]=p[i-1];
		p[i-1]=tmp;
		
		int k=size;
		while(i<k) {
			tmp=p[k];
			p[k]=p[i];
			p[i]=tmp;
			i++;
			k--;
		}
		return true;
	}

}
