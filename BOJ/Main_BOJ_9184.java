import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_9184 {

	static int dp[][][]=new int[51][51][51];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a,b,c,num;
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			if(a==-1&&b==-1&&c==-1) break;
			
			num=w(a,b,c);
			
			System.out.println("w("+a+", "+b+", "+c+") = "+num);
		}
	}
	
	static int w(int a,int b, int c) {
		if(check(a,b,c)&&dp[a][b][c]!=0) return dp[a][b][c];
		
		if(a<=0||b<=0||c<=0) return 1;
		
		if(a>20||b>20||c>20) return dp[20][20][20]=w(20,20,20);
		if(a<b && b<c) return dp[a][b][c]=w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		return dp[a][b][c]=w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	static boolean check(int a,int b,int c) {
		return a>=0&&a<51&&b>=0&&b<51&&c>=0&&c<51;
	}
}
