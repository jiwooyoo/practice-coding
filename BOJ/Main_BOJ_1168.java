import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BOJ_1168 {

	public static void main(String[] args) throws IOException {
		HashMap<Integer,Integer> list=new HashMap<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());  
		
		StringBuilder sb=new StringBuilder();
		for (int i = 1; i <= N; i++) {
			list.put(i-1, i);
		}
		
		sb.append("<");
		
		System.out.println(list.get(3));
		list.remove(1);
		System.out.println(list.get(3));
		
		int index=K-1;
		while(true) {
			System.out.println("index:"+index+" "+list.get(index));
			sb.append(list.get(index));
			list.remove(index);
			System.out.println(list.size());
			if(list.size()==0) break;
			if(list.isEmpty()) break;
			sb.append(", ");
			index+=K;
			index%=N;
		}
		
		sb.append(">");
		System.out.println(sb);
	}

}
