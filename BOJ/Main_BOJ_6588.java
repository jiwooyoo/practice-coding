import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_6588 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime=new boolean[1000001];
		for (int i = 2; i <= 1000000; i++) {
			for (int j = 2; j <= 1000000/i; j++) {
				if(prime[i*j]) continue;
				prime[i*j]=true;
			}
		}
		
		int n;
		StringBuffer sb=new StringBuffer();
		while(true) {
			n=Integer.parseInt(br.readLine());
			if(n==0) break;
			boolean flag=false;
			for (int i = 2; i <= n/2; i++) {
				if(!prime[i]&&!prime[n-i]) {
					sb.append(n+" = ");
					sb.append(i+" + ");
					sb.append(n-i);
					sb.append("\n");
					flag=true;
					break;
				}
			}
			
			if(!flag) {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
