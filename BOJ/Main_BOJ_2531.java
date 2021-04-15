import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2531 {

	static int N,d,k,c;
	static int[] sushi;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		sushi=new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i]=Integer.parseInt(br.readLine());
		}
		
		int res=0;
		for (int i = 0; i < N; i++) {
			int num=countDishes(i);
			if(res<num) res=num;
		}
		System.out.println(res);
	}
	
	private static int countDishes(int start) {
		boolean[] eat=new boolean[d+1];
		eat[c]=true;
		int end=(start+k);
		int tot=1; // 쿠폰 번호  
		for (int i = start; i < end; i++) {
			if(eat[sushi[i%N]]) continue;  // 이미 먹은 번호의 접시  
			eat[sushi[i%N]]=true;
			tot++;   // 아직 안 먹은 번호의 접시면 +1 
		}
	//	System.out.println(start+" "+end+" "+tot);
		return tot;
	}

}
