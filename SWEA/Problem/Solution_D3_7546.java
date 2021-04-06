import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_7546 {

	static int tc;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		tc=Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String S=br.readLine();
			String T=br.readLine();
			
			StringBuffer sb=new StringBuffer();
			sb.append(T);
			
			Queue<StringBuffer> q=new LinkedList<>();
			q.offer(sb);
			
			int res=0;
			while(!q.isEmpty()) {
				StringBuffer current=q.poll();
				StringBuffer temp1=new StringBuffer();
				temp1.append(current);
				StringBuffer temp2=new StringBuffer();
				temp2.append(current);
				
			//	System.out.println("cur: "+current);
				if(current.toString().equals(S)) {
					res=1;
					break;
				}
				//A추가
				if(temp1.charAt(temp1.length()-1)=='A') {
					temp1.deleteCharAt(temp1.length()-1);
					if(temp1.length()>=S.length()) q.offer(temp1);
				}
				//System.out.println("1: "+temp1);
				
				//뒤집고 B추가
				if(temp2.charAt(temp2.length()-1)=='B') {
					temp2.deleteCharAt(temp2.length()-1);
					temp2.reverse();
					//System.out.println("2: "+temp2);
					if(temp2.length()>=S.length()) q.offer(temp2);
				}
				
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
