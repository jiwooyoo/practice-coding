import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2804 {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String A,B;
		StringTokenizer st=new StringTokenizer(br.readLine());
		A=st.nextToken();
		B=st.nextToken();
		int N=A.length();
		int M=B.length();
		
		int indexA=0,indexB=0;
		AA:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(A.charAt(i)==B.charAt(j)) {
					indexA=i;
					indexB=j;
					break AA;
				}
			}
		}
		
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < M; i++) {
			if(i==indexB) {
				for (int j = 0; j < N; j++) {
					sb.append(A.charAt(j));
				}
			}
			else {
				for (int j = 0; j < N; j++) {
					if(j==indexA) {
						sb.append(B.charAt(i));
					}
					else {
						sb.append(".");
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
