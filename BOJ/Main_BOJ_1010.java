import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N,M;
		int T;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			int dp[][]=new int[31][31];
			
			for(int j=1;j<=M;j++) {
				for(int k=1;k<=M&&k<=N;k++) {
					if(dp[j][k]!=0) continue;
					
					if(j==k||j==1) dp[j][k]=1;
					else if(k==1) dp[j][k]=j;
					else dp[j][k]=dp[j-1][k-1]+dp[j-1][k];
					//System.out.println(dp[j][k]);
				}
			}
			
			
			System.out.println(dp[M][N]);
		}
		
	}

}
