import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_1377 {
	static class Node implements Comparable<Node>{
		int value;
		int index;
		
		
		
		public Node(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			return value-o.value;   //오름차순으로 정렬
		}
		
	}
	
	static int N;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		Node[] node=new Node[N];
		
		for (int i = 0; i < N; i++) {
			int num=sc.nextInt();
			node[i]=new Node(num,i);
		}
		
		Arrays.sort(node);
		
		int max=0;
		for (int i = 0; i < N; i++) {
			max=Math.max(max,node[i].index-i);
		}
		
		System.out.println(max+1);
	}

}
