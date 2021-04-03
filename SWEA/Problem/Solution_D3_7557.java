import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Solution_D3_7557 {

	static int T,N;
	static int[] zoo;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			zoo=new int[N];
			boolean check=true;
			for (int i = 0; i < N; i++) {
				int key=sc.nextInt();
				if(key>=N) {
					check=false;
					continue;
				}
				zoo[key]++;
			}
			int res=0,same=0;
			boolean flag=false;
			if(check) {
				for (int i = 0; i < N; i++) {
					if(zoo[i]>2) {
						check=false;
						break;
					}
					if(i!=0 && zoo[i-1]<zoo[i]) {
						check=false;
						break;
					}
					if(zoo[i]==2) {
						same++;
					}
					else if(zoo[i]==1)
						flag=true;
				}
			}
			
			if(!check) res=0;
			else {
				res=(int)Math.pow(2, same);
				if(flag) res*=2;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
