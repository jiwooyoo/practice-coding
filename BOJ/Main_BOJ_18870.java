import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main_BOJ_18870 {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		int N=Integer.parseInt(br.readLine());
		int[] x=new int[N]; //원본 배열 
		int[] res=new int[N];  // 정렬할 배열 
		HashMap<Integer, Integer> rank = new HashMap<Integer, Integer>();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			x[i]=Integer.parseInt(st.nextToken());
			res[i]=x[i];
		}
		
		Arrays.sort(res);
		
		int temp=0;
		for(int i : res) {
			if(!rank.containsKey(i)) { // x[i]를 키값으로 가진게 없다면 추가 
				rank.put(i, temp);
				temp++;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(rank.get(x[i])).append(' ');
		}
		
		System.out.println(sb);
	}

}
