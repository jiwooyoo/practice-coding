import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_14226 {

	static class Node{
		int num;
		int clip;
		int cnt;
		public Node(int num, int clip, int cnt) {
			super();
			this.num = num;
			this.clip=clip;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int S=sc.nextInt();
		boolean[][] v=new boolean[1100][1100];
		Queue<Node> q=new LinkedList<>();
		q.offer(new Node(1,0,0));
		v[1][0]=true;
		
		while(!q.isEmpty()) {
			Node n=q.poll();
			int num=n.num;
			int clip=n.clip;
			int cnt=n.cnt;
			v[num][clip]=true;
			if(num==S) {
				System.out.println(cnt);
				return;
			}
			
			if(num!=0 && !v[num][num]) q.offer(new Node(num,num,cnt+1)); //1,1,1   
			if(clip!=0 && num+clip<= 1001 && !v[num+clip][clip]) q.offer(new Node(num+clip,clip,cnt+1));
			if(num>1&&!v[num-1][clip]) q.offer(new Node(num-1,clip,cnt+1));
		}
	}

}
