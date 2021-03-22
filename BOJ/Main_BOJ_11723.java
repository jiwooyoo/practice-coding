import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11723 {

	static int M;
	static boolean[] S=new boolean[21];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		M=Integer.parseInt(br.readLine());
		StringBuffer sb=new StringBuffer();
		
		for (int i = 0; i < M; i++) {
			String s=br.readLine();
			StringTokenizer st=new StringTokenizer(s);
			String comm=st.nextToken();
			if(comm.equals("add")) {
				S[Integer.parseInt(st.nextToken())]=true;
			}else if(comm.equals("remove")) {
				S[Integer.parseInt(st.nextToken())]=false;
			}else if(comm.equals("check")) {
				int num=Integer.parseInt(st.nextToken());
				//if(S[num]) {
				sb.append(S[num]?1:0);
				sb.append("\n");
				//}
			}else if(comm.equals("toggle")) {
				int num=Integer.parseInt(st.nextToken());
				if(S[num]) {
					S[num]=false;
				}
				else {
					S[num]=true;
				}
			}else if(comm.equals("all")) {
				Arrays.fill(S, true);
			}else {
				Arrays.fill(S, false);
			}
			
		}
		
		System.out.println(sb);
	}

}
