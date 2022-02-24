import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		long dist[]=new long[N];
		int liter[]=new int[N+1];
		long dp[]=new long[N+1];  // 넣는 최소 비
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int i=0;
		while(st.hasMoreTokens()) {
			dist[i++]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		i=0;
		while(st.hasMoreTokens()) {
			liter[i++]=Integer.parseInt(st.nextToken());
		}
		
		//dp[0]=totDis*liter[0]; // 첫번째에서 기름을 다 채웠다고 가정  
		int min=liter[0];
		dp[0]=0;
		for(int j=1;j<N;j++) {
			if(liter[j-1]<min) {
				min=liter[j-1];
			}
			
			dp[j]=dp[j-1]+min*dist[j-1];
		//	System.out.println(min+" "+dp[j]);
		}
		
		
		System.out.println(dp[N-1]);
	}

}
