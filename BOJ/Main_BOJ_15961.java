import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_15961 {

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
		
		int low=0, high=0,res=0;  // 투 포인터 사용하여 탐색  
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();  // 중복 확인을 위한 맵 사용 
		while(low<N) {
			if(map.containsKey(sushi[(high+N)%N])) {
				int num=map.get(sushi[(high+N)%N]);   //  이미 맵에 있으면 값만 증가  
				map.put(sushi[(high+N)%N], num+1);
			} else {
				map.put(sushi[(high+N)%N], 1);  // 이 구간에 하나만 존재한다는 의미로 1 넣기  
			}
			
			/*  쿠폰  여부 판단  */
			if(map.containsKey(c)) {
				res=Math.max(res, map.keySet().size());
			}else {
				res=Math.max(res, map.keySet().size()+1);
			}
			
			if(high-low+1>=k) {  // k 개 채웠으니 둘다 인덱스 한칸씩 이동  
				int num=map.get(sushi[(low+N)%N]);
				if(num==1) {
					map.remove(sushi[(low+N)%N]);
				}
				else {
					map.put(sushi[(low+N)%N], num-1);
				}
				high++;
				low++;
			}
			else {
				// 아직 먹을 수 있는 접시 개수 남아있으므로 뒤만 증가 
				high++;
			}
		}
		
		System.out.println(res);
	}

}
