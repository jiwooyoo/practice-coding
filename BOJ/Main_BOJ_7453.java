import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_7453 {

	static int n;
	static long[] A,B,C,D,AB,CD;
	static long res;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		A=new long[n];
		B=new long[n];
		C=new long[n];
		D=new long[n];
		AB=new long[n*n];
		CD=new long[n*n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			A[i]=Long.parseLong(st.nextToken());
			B[i]=Long.parseLong(st.nextToken());
			C[i]=Long.parseLong(st.nextToken());
			D[i]=Long.parseLong(st.nextToken());
		}
		
		int index=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[index++]=A[i]+B[j];
			}
		}
		
		index=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				CD[index++]=C[i]+D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int abIn=0;
		int cdIn=index-1;
		
		while(index>abIn && cdIn>=0) {
			long abSum=AB[abIn];
			long cdSum=CD[cdIn];
			int abCnt=0,cdCnt=0;
			long tot=abSum+cdSum;
			
			if(tot==0) {
				while(index>abIn && abSum==AB[abIn]) {
					abIn++;
					abCnt++;
				}
				
				while(cdIn>=0 && cdSum==CD[cdIn]) {
					cdIn--;
					cdCnt++;
				}
				
				res+=(long)abCnt*(long)cdCnt;
			}else if(tot>0) { //크면 값을 줄여야함 
				cdIn--;
			}
			else {
				abIn++;
			}
		}
		
		System.out.println(res);
		
	}

}
