import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1248 {
	static int N;
	static char[][] arr;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new char[N][N];
		p=new int[N];
		
		String s=br.readLine();
		int index=0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				arr[i][j]=s.charAt(index++);
			}
		}
		
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt==N) {
			for (int i = 0; i < N; i++) {
				System.out.print(p[i]+" ");
			}
			System.out.println();
			System.exit(0);
			return;
		}
		
		for (int i = -10; i <= 10; i++) {
			p[cnt]=i;
			if(check(cnt)) {
				perm(cnt+1);
			}
		}
	}

	private static boolean check(int cnt) {
		for (int i = 0; i <= cnt; i++) {
			int sum=0;
			for (int j = i; j <= cnt; j++) {
				sum+=p[j];
				if(arr[i][j]=='-') {
					if(sum>=0) return false; 
				}
				else if(arr[i][j]=='+') {
					if(sum<=0) return false;
				}
				else {
					if(sum!=0) return false;
				}
			}
		}
		return true;
	}

}
