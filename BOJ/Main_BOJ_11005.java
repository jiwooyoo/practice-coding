import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11005 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String N=st.nextToken();
		int B=Integer.parseInt(st.nextToken());
		StringBuffer sb=new StringBuffer();
		if(Integer.parseInt(N)<=1) {
			System.out.println(N);
		}
		else {
			int num=Integer.parseInt(N);
			while(num!=0) {
				if(num%B>=10) {
					sb.append((char)(num%B+'7'));
				}
				else sb.append(num%B);
			//	System.out.println(num);
				num/=B;
			}
		//	sb.append(num);
			
			sb.reverse();
			System.out.println(sb);
		}
	}

}
