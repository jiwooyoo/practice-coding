import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2480 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int D1,D2,D3;
		D1=Integer.parseInt(st.nextToken());
		D2=Integer.parseInt(st.nextToken());
		D3=Integer.parseInt(st.nextToken());
		
		int tot=0;
		if(D1==D2&&D2==D3) {
			tot=10000+D1*1000;
		}
		else if(D1==D2) {
			tot=1000+D1*100;
		}
		else if(D2==D3) {
			tot=1000+D2*100;
		}
		else if(D1==D3) {
			tot=1000+D1*100;
		}
		else {
			int most=Math.max(D1,D2);
			most=Math.max(most, D3);
			tot=most*100;
		}
		
		System.out.println(tot);

	}

}
