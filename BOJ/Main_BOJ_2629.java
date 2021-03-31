import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2629 {
	static int N,M;
	static int[] chu,glass;
	static boolean[] check,dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		chu=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int sum=0;
		for (int i = 0; i < N; i++) {  //추 문자열
			chu[i]=Integer.parseInt(st.nextToken());
			sum+=chu[i];
		}
		M=Integer.parseInt(br.readLine());
		glass=new int[M];
		st=new StringTokenizer(br.readLine());
		int max=30*500;  //구슬 최고 무겐
		for (int i = 0; i < M; i++) {  //구슬 문자열
			glass[i]=Integer.parseInt(st.nextToken());
			//if(max<glass[i]) max=glass[i];
		}
		dp=new boolean[max+1];
		check=new boolean[max+1];
		dp[0]=true;
		check[0]=true;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= max; j++) {
				if(dp[j]) {
					int left=Math.abs(chu[i]-j);
					int right=Math.abs(chu[i]+j);
					
					if(left<=max && !check[left]) check[left]=true;
					if(right<=max && !check[right]) check[right]=true;
					if(chu[i]<=max && !check[chu[i]]) check[chu[i]]=true;
				}
			}
			
			for (int j = 0; j <= max; j++) {
				dp[j]=check[j];
			}
		}
		
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < M; i++) {
			if(glass[i]>max) sb.append("N ");
			else {
				if(dp[glass[i]]) sb.append("Y ");
				else sb.append("N ");
			}
			
		}
		
		System.out.println(sb);
	}

}
