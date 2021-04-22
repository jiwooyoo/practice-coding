import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_sw_2115 {
	/*
	 *  두명의 일꾼이 서로 겹치지 않게 꿀을 선택 --> 조합 
	 *  
	 *  일꾼 1을 고정 -> 일꾼2를 바꾸며 최대 이익 선택 ! 
	 *  일꾼 1과 같은 행의 뒤쪽+다음행 
	 */

	static int N,M,C;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		for (int t = 1; t <= T; t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+t+" "+getMaxBenefit());
		}
	}

	private static int getMaxBenefit() {
		return processCombination();
	}
	
	private static int processCombination() {
		int result=0,aBenefit=0,bBenefit=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {  // 첫 열부터 연속된 M개가 채취가 가능한 열까지, 일군 A의 선택  
				// 선택된 M개의 벌통에서 얻을 수있는 최대 이익  
				maxSum=0;
				makeMaxSubset(i,j,0,0,0);
				aBenefit=maxSum;
				
				bBenefit=0;
				// 일꾼 B의 선택  
				// 일꾼 A와 같은 행에 뒷쪽 열에서 선택  
				for (int j2 = j+M; j2 <= N-M; j2++) {
					maxSum=0;
					makeMaxSubset(i, j2, 0, 0, 0);  //maxSum
					if(bBenefit<maxSum) {
				//		System.out.println("** "+maxSum+" "+j2);
						bBenefit=maxSum;
					}
				}
				
				//일꾼 A의 다음행에서 선택  
				for (int i2 = i+1; i2 < N; i2++) {  //행 
					for (int j2 = 0; j2 <= N-M; j2++) { //열 
						maxSum=0;
						makeMaxSubset(i2,j2,0,0,0);
						if(bBenefit<maxSum) {
				//			System.out.println("*-- "+maxSum+" "+i2+" "+j2);
							bBenefit=maxSum;
						}
					}
				}
				
				if(result<aBenefit+bBenefit) {
					result=aBenefit+bBenefit;
				///	System.out.println(i+" "+j+" "+bBenefit);
				}
			}
		}
		
		return result;
	}

	private static int maxSum=0;
	private static void makeMaxSubset(int i,int j,int cnt,int sum,int powerSum) {
		if(sum>C) return; //가지치기 겸 리턴시키기 
		
		// 마지막 원소까지 다 부분집합에 고려해봤다면 
		if(cnt==M) {
			if(maxSum<powerSum) maxSum=powerSum;
			return;
		}
		
		// 선택
		makeMaxSubset(i,j+1,cnt+1,sum+map[i][j],powerSum+pow(map[i][j]));
		// 비선택 
		makeMaxSubset(i,j+1,cnt+1,sum,powerSum);
	}

	public static int pow(int x) {
		return x*x;
	}
}
