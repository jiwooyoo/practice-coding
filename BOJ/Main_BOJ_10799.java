import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_10799 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] input=br.readLine().toCharArray();
		int N=input.length;
		
		Stack<Character> st=new Stack<Character>();
		int tot=0;
		for (int i = 0; i < N; i++) {
			if(input[i]=='(') {
				st.push(input[i]);
			}
			else {
				if(input[i-1]=='(') {
					st.pop();  // 레이저이므로 앞에 괄호 뽑아버리기 
					tot+=st.size();
				}else {
					st.pop();
					tot++;
				}
			}
		//	System.out.println(i+" "+tot);
		}
		
		System.out.println(tot);
	}

}
