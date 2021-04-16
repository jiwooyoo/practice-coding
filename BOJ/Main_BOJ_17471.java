import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_17471 {

	static int N;
	static int[] person;
	static boolean[] visit;
	static ArrayList<Integer> list[];
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		person=new int[N+1];
		visit=new boolean[N+1];
		for (int i = 1; i < N+1; i++) {
			person[i]=sc.nextInt();
		}
		
		list=new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i]=new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			int cnt=sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int num=sc.nextInt();
				list[i].add(num);
			}
		}
		
		if(N==2) min=Math.abs(person[2]-person[1]);
		else subset(1,1);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	private static void subset(int cnt,int n) {
		if(cnt==N) {
		//	System.out.println("* "+n);
			if(n==1||n==N+1) return;
			if(!check()) return;
			
			int n1=0,n2=0;
	  		for (int i = 1; i < N+1; i++) {
				if(visit[i]) n1+=person[i];
				else n2+=person[i];
			}
		//	System.out.println(n1+" "+n2);
	  		min=Math.min(min, Math.abs(n1-n2));
			return;
		}
		
			// O
			visit[cnt+1]=true;
			subset(cnt+1,n+1);
			
			// X
			visit[cnt+1]=false;
			subset(cnt+1,n);
	}

	private static boolean check() {
		Queue<Integer> q1=new LinkedList<>();
		Queue<Integer> q2=new LinkedList<>();
		int n1=0,n2=0;
  		for (int i = 1; i < N+1; i++) {
			if(visit[i]) n1=i;
			else n2=i;
		}
  		q1.add(n1);
  		q2.add(n2);
  		boolean[] out=new boolean[N+1];
  		out[n1]=true;
  		out[n2]=true;
  		while(!q1.isEmpty()) {
  			int num=q1.poll();
  	//		System.out.println(num);
  			for (int i = 0; i < list[num].size(); i++) {
  				int index=list[num].get(i);
				if(out[index]||!visit[index]) continue;
				out[index]=true;
				q1.add(index);
			}
  		}
  		
  		while(!q2.isEmpty()) {
  			int num=q2.poll();
  			for (int i = 0; i < list[num].size(); i++) {
  				int index=list[num].get(i);
				if(out[index]||visit[index]) continue;
				out[index]=true;
				q2.add(index);
			}
  		}
  		
  		for (int i = 1; i <= N; i++) {
			if(!out[i]) return false;
		}
  		
  		return true;
	}

}
