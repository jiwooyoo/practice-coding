import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1806 {

	static int N,S;
	static int[] arr,sum,least;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		sum=new int[N];
		least=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int start=0,end=0;
		int tot=0;
		int min=Integer.MAX_VALUE;
		
		while(true) {
			if(tot>=S) {
				tot-=arr[start++];
				if(min>end-start+1) {
					min=end-start+1;
				}
			}
			else if(end==N) break;
			else {
				tot+=arr[end++];
			}
		}
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else {
			System.out.println(min);
		}
	}

}
