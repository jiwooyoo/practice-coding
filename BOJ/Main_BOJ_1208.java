import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_BOJ_1208 {

	static int N,S;
	static int[] arr;
	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> A=new ArrayList<>();
		ArrayList<Integer> B=new ArrayList<>();
		
		//반으로 나눠서 부분수열합 구하기
		dfs(0,N/2,0,A);
		dfs(N/2,N,0,B);
		
		Collections.sort(A);
		Collections.sort(B);
		
		long res=0;
		int indexA=0,indexB=B.size()-1;
		while(indexB>=0 && indexA<A.size()) {
			long numA=A.get(indexA);
			long numB=B.get(indexB);
			long sum=numA+numB;
			
			long cntA=0,cntB=0;
			if(sum==S) {
				while(indexA<A.size() && A.get(indexA)==numA) {
					indexA++;
					cntA++;
				}
				
				while(indexB>=0 && B.get(indexB)==numB) {
					indexB--;
					cntB++;
				}
				
				res+=cntA*cntB;
			}
			else if(sum>S) {
				indexB--;
			}
			else {
				indexA++;
			}
		}
		
		//구하고자 하는 합이 0일 때는 공집합이 포함되므로 1을 빼준다.
		if(S==0) System.out.println(res-1);
		else System.out.println(res);
		
	}
	
	private static void dfs(int start, int end, int sum, ArrayList<Integer> a) {
		if(start>=end) {
			a.add(sum);
			return;
		}
		
		dfs(start+1,end,sum+arr[start],a);
		dfs(start+1,end,sum,a);
	}

}
