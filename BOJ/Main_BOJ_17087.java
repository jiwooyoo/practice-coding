import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_17087 {
	
	static long N,S;
	static List<Long> list=new ArrayList<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Long.parseLong(st.nextToken());
		S=Long.parseLong(st.nextToken());
		
		
		st=new StringTokenizer(br.readLine());
		Long min=Long.MAX_VALUE;
		while(st.hasMoreTokens()) {
			Long l=Long.parseLong(st.nextToken());
			list.add(l);
			if(min>Math.abs(l-S)) min=Math.abs(l-S);
		}
		
		long D=min;
		int index=1;
		while(D!=0) {
			if(D%index==0) {
				if(check(D/index)) {
					D/=index;
					break;
				}
			}
			index++;
		}
		System.out.println(D);
	}
	
	private static boolean check(long D) {
		for (int i = 0; i < N; i++) {
			if(Math.abs(S-list.get(i))%D!=0) return false;
		}
		return true;
	}
}
