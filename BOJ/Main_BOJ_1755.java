import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_BOJ_1755 {

	static class Node implements Comparable<Node>{
		String s=null;
		int index;
		
		public Node(String s, int index) {
			super();
			this.s = s;
			this.index = index;
		}
		
		@Override
		public int compareTo(Node o2) {
			int i=0;
			while(i<this.s.length()&& i<o2.s.length()&&this.s.charAt(i)==o2.s.charAt(i)) {
				i++;
			}
			if(i==this.s.length()) return -1;
			if(i==o2.s.length()) return 1;
			return this.s.charAt(i)-o2.s.charAt(i);
		}
	}
	static int M,N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		String[] alpha= {"zero","one","two","third","four","five","six","seven","eight","nine"};
		Node[] node=new Node[N-M+1];
		for (int i = M; i <= N; i++) {
			int tenN=i/10;
			int oneN=i%10;
			String s="";
			if(tenN!=0) s+=alpha[tenN]+" ";
			s+=alpha[oneN];
			node[i-M]=new Node(s,i);
		}
		
		
		
		Arrays.sort(node);
	
		for (int i = 0; i < N-M+1; i++) {
			System.out.print(node[i].index+" ");
			if(i%10==9) System.out.println();  //10개 단위로 줄 바꾸기
		}
	}

}
