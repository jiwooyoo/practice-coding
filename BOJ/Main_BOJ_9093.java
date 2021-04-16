import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *   버퍼로 한줄 단위로 입력 받은 후 , 토큰화 한 후 뒤집기 
 */

public class Main_BOJ_9093 {

	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBuffer sb=new StringBuffer();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] s=br.readLine().trim().split(" ");
			for (int i = 0; i < s.length; i++) {
				StringBuffer tmp=new StringBuffer();
				tmp.append(s[i]);
				tmp.reverse();
				sb.append(tmp);
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
