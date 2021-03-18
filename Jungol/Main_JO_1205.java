package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1205 {

	static int N;
	static int[] card,diff;
	static int max,zero;
	static Queue<Integer> q=new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		card=new int[N];
		for (int i = 0; i < N; i++) {
			card[i]=Integer.parseInt(st.nextToken());
			if(card[i]==0) zero++;
		}
//		System.out.println(zero);
		Arrays.sort(card);
//		System.out.println(Arrays.toString(card));
		diff=new int[N];
		diff[0]=0;
		for (int i = 1; i < N; i++) {
			diff[i]=card[i]-card[i-1];
			if(diff[i]>1)
				q.offer(i);
		}
		
		if(zero==N)
			max=N;
		else {
			q.offer(zero);
		//	System.out.println(q.size());
			while(!q.isEmpty()) {
				getCount(q.poll());
			}
		}
		
		System.out.println(max);
	}
	
	private static void getCount(int start) {
		int tot=1;
		int znum=zero;
		for (int i = start; i < N-1; i++) {
			if(diff[i+1]==1) {
				tot++;
			}
			else if(diff[i+1]==0){
				continue;
			}
			else {
				if(diff[i+1]-1<=znum) {
					tot+=diff[i+1];
					znum-=(diff[i+1]-1);
				//	q.offer(i);
				}
				else {
					tot+=znum;
					if(max<tot) {
						max=tot;
					}
					tot=1;
					znum=zero;
				}
			}
		}
		max=Math.max(max, tot+znum);
	}

}
