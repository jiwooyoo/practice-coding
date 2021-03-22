import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9613 {

	static int T,N;
	static int[] num;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			num=new int[N];
			for (int i = 0; i < N; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			long sum=0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					sum+=gcd(num[i],num[j]);
				}
			}
			System.out.println(sum);
		}
	}
	private static int gcd(int i, int j) {
		if(i<j) {
			int temp=i;
			i=j;
			j=temp;
		}
		
		while(j!=0) {
			int temp=i%j;
			i=j;
			j=temp;
		}
		
		return i;
	}

}
