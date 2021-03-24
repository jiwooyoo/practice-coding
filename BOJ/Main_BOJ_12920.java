import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_12920 {

	static int N,M;
	static int[][] bag;
	static int[] satisfy;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		ArrayList<int[]> list=new ArrayList<>();
		satisfy=new int[M+1];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int V=Integer.parseInt(st.nextToken());  //무게
			int C=Integer.parseInt(st.nextToken());  //만족도
			int K=Integer.parseInt(st.nextToken());  //개수
			
			int index=1;
			K=16;
			while(K>0) {
				int temp=Math.min(index, K);
				list.add(new int[] {V*temp,C*temp});
				index*=2;
				K-=temp;
				System.out.println(index+" "+K);
			} 
			
		}
	
		int len=list.size();
		for (int i = 0; i < len; i++) {
			for (int j = M; j > 0; j--) {
				if(list.get(i)[0]<=j) {
					satisfy[j]=Math.max(satisfy[j], satisfy[j-list.get(i)[0]]+list.get(i)[1]);
				}
			}
		}
		System.out.println(satisfy[M]);
	}

}
