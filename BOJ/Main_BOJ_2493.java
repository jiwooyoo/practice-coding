import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());//sc.nextInt();
		int[] tower=new int[N];
		int[] res=new int[N];
		String[] s=br.readLine().trim().split(" ");
		for (int i = 0; i < N; i++) {
			tower[i]=Integer.parseInt(s[i]);
		}
		
		Stack<int[]> st=new Stack<>();
		for (int i = 0; i < N; i++) {
			if(st.isEmpty()) {
				res[i]=0;
				int[] arr= {i+1,tower[i]};
				st.push(arr);
			}
			else {
				
				int[] arr=st.peek();
				if(arr[1]<=tower[i]) {
					boolean flag=false;
					while(arr[1]<=tower[i]) {
						st.pop();
						if(st.isEmpty()) {
							res[i]=0;
							flag=true;
							break;
						}
						arr=st.peek();
					}
					if(!flag){
						res[i]=arr[0];
					}
					int[] temp= {i+1,tower[i]};
					st.push(temp);
				}
				else {
					res[i]=arr[0];
					int[] temp= {i+1,tower[i]};
					st.push(temp);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(res[i]+" ");
		}
	}

}
