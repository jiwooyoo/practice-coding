import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_10845 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		N=Integer.parseInt(br.readLine());
		
		Deque<Integer> q=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String[] s=br.readLine().split(" ");
			String com=s[0];
			switch(com) {
			case "push":
				int num=Integer.parseInt(s[1]);
				q.offer(num);
				break;
			case "pop":
				if(!q.isEmpty()) sb.append(q.pollFirst()+"\n");
				else sb.append("-1\n");
				break;
			case "size":
				sb.append(q.size()+"\n");
				break;
			case "empty":
				if(q.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.peekFirst()+"\n");
				break;
			case "back":
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.peekLast()+"\n");
				break;
			}
		}
		
		System.out.println(sb);
	}

}
