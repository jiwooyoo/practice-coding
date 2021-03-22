import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2_BOJ_11723 {

	static int M;
	static int S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		M=Integer.parseInt(br.readLine());
		StringBuffer sb=new StringBuffer();
		
		for (int i = 0; i < M; i++) {
			String s=br.readLine();
			StringTokenizer st=new StringTokenizer(s);
			String comm=st.nextToken();
			if(comm.equals("add")) {
				int num=Integer.parseInt(st.nextToken());
				S=S|1<<num;
			}else if(comm.equals("remove")) {
				int num=Integer.parseInt(st.nextToken());
				if((S&1<<num)>0) {
					S=S^1<<num;
				}
			}else if(comm.equals("check")) {
				int num=Integer.parseInt(st.nextToken());
				if((S&1<<num)!=0) {
					sb.append("1");
					sb.append("\n");
				}
				else {
					sb.append("0");
					sb.append("\n");
				}
			}else if(comm.equals("toggle")) {
				int num=Integer.parseInt(st.nextToken());
				S=S^1<<num;
			}else if(comm.equals("all")) {
				for (int j = 1; j < 21; j++) {
					S=S|1<<j;
				}
			}else {
				S=0;
			}
			
		}
		
		System.out.println(sb);
	}

}
