import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_7463 {

	static int T;
	static int N,K,M;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			K=sc.nextInt();
			M=sc.nextInt();
			
			int index=0;
			if(K%N==0) index=N;
			else index=K%N;
			
			int res=0;  
			/* index는 현재 제거해야 할 인덱스이며
			 * M은 M 현재 위치하는 인덱스이다. (인덱스를 1부터라고 계산해주면 인덱스 값은 곧 현재값) 
			 * 따라서 지금 제거해야 할 인덱스와 M이 위치하는 인덱스가 같으면 우리가 목표했던 값이 제거되는 것 
			 * 원래 값을 유지해야 된다는 생각을 버릴 것! */
			while(true) {
				res++;
				if(index==M) {
					break;
				}
				
				if(index>M) { 
					M-=index;
					M+=N;
				}
				else { //이번에 빠진애가 M보다 앞이었다면
					M-=index;
				}
				
				N--;  //누구 한명이 제거됐으므로
				if(K%N==0) index=N; //인덱스가 0이 없게 했으므로(1부터 시작) 맨 뒤로 보내기
				else index=K%N;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
