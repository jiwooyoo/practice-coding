import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2745 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String N=st.nextToken();
		int B=Integer.parseInt(st.nextToken());
		
		int len=N.length();
		int index=1;
		int res=0;
		for (int i = 0; i < len ; i++) {
			int num=N.charAt(len-1-i);
			if(Character.isAlphabetic(num)) {
				num=num-'7';
			}
			else{
				num=num-'0';
			}
			res+=num*index;
		//	System.out.println(N.charAt(len-1-i)-'0');
			index*=B;
		}
		
		
	//	System.out.println('A'-'7');
		System.out.println(res);
	}

}
