import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_17103 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] gold=new boolean[1000001];
		for (int i = 2; i <= 1000000; i++) {
			for (int j = 2; j <= 1000000/i; j++) {
				if(!gold[i*j]) {
					gold[i*j]=true;
				}
			}
		}
		
		int T=Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int sum=0;
			int N=Integer.parseInt(br.readLine());
			for (int j = 2; j <= N/2; j++) {
				if(!gold[j]&&!gold[N-j])
					sum++;
			}
			
			System.out.println(sum);
		}
	}

}
