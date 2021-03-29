import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_7560 {

	static int T,N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr=new int[N];
			dp=new int[N];
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			dp[0]=arr[0];
			int sum=dp[0];
			for (int i = 1; i < N; i++) {
				dp[i]=dp[i-1]+arr[i];
				sum+=dp[i];
			}
			//System.out.println(Arrays.toString(dp));
			System.out.println("#"+t+" "+sum);
		}
		
	}

}
