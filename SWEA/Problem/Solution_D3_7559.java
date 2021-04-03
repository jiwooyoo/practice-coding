import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_7559 {

	static int T,A,B;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			A=sc.nextInt();
			B=sc.nextInt();
			
			Queue<long[]> q=new LinkedList<>();
			q.offer(new long[] {A,0});
			
			long tot=0;
			while(!q.isEmpty()) {
				long[] temp=q.poll();
				if(temp[0]>B) continue;
				if(temp[0]==B) {
					tot=temp[1];
					break;
				}
				
				q.offer(new long[] {temp[0]*2,temp[1]+1});
				q.offer(new long[] {temp[0]*10+1,temp[1]+1});
			}
			
			if(tot==0) System.out.println("#"+t+" -1");
			else System.out.println("#"+t+" "+(tot+1));
		}
	}

}
