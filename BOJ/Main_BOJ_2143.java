import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_2143 {

	static int T,N,M;
	static int[] A,B,sumA,sumB;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		N=Integer.parseInt(br.readLine());
		A=new int[N];
		sumA=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i]=Integer.parseInt(st.nextToken());
			if(i==0) sumA[i]=A[i];
			else sumA[i]=sumA[i-1]+A[i];
		}
		M=Integer.parseInt(br.readLine());
		B=new int[M];
		sumB=new int[M];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i]=Integer.parseInt(st.nextToken());
			if(i==0) sumB[i]=B[i];
			else sumB[i]=sumB[i-1]+B[i];
		}
		
		ArrayList<Integer> listA=new ArrayList<>();
		ArrayList<Integer> listB=new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			listA.add(sumA[i]);
			for (int j = 0; j < i; j++) {
				listA.add(sumA[i]-sumA[j]);
			}
		}
		Collections.sort(listA);
		
		for (int i = 0; i < M; i++) {
			listB.add(sumB[i]);
			for (int j = 0; j < i; j++) {
				listB.add(sumB[i]-sumB[j]);
			}
		}
		Collections.sort(listB);
		
		int indexA=0,indexB=listB.size()-1;
		long res=0;
		while(indexB>=0 && indexA<listA.size()) {
			int numA=listA.get(indexA);
			int numB=listB.get(indexB);
			
			if(numA+numB==T) {
				long cntA=0,cntB=0;
			//	System.out.println(indexA+" "+indexB);
				while(indexA<listA.size()&&numA==listA.get(indexA)) {
					cntA++;
					indexA++;
				}
				
				while(indexB>=0 && numB==listB.get(indexB)) {
					cntB++;
					indexB--;
				}
				
				res+=cntA*cntB;
			}else if(numA+numB>T) {
				indexB--;
			}else {
				indexA++;
			}
			
		}
		
		System.out.println(res);
	}

}
