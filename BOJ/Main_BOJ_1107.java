import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_BOJ_1107 {

	static String N;
	static int M;
	static int tot;
	static List<Character> list=new ArrayList<Character>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=br.readLine().trim();
		M=Integer.parseInt(br.readLine().trim());
		if(M==0) {
			int result=Math.min(N.length(),Math.abs(100-Integer.parseInt(N)));
			System.out.println(result);
			System.exit(0);
		}
		for (int i = 0; i < 10; i++) {
			list.add((char)(i+'0'));
		}
		
		String[] s=br.readLine().trim().split(" ");
		for (int i = 0; i < M; i++) {
			delete(s[i].charAt(0));
		}
		
		int num1=Integer.parseInt(N);
		int num2=Integer.parseInt(N);
		String res="";
		int s1=0,s2=0,sz=0;
		boolean flag1=false,flag2=false;
		
		int temp=Math.abs(100-Integer.parseInt(N));
		if(!check(N)) {
			while(true) {
				tot++;
				if(tot>temp) break;
				num1++;  //위로
				if(check(num1+"")) {
					res=num1+"";
					s1=res.length();
					flag1=true;
				}
				num2--;  //아래로
				if(num2>=0) {
					if(check(num2+"")) {
						res=num2+"";
						s2=res.length();
						flag2=true;
					}
				}
				
				if(flag1&&flag2) {
					sz=Math.min(s1, s2);
					tot+=sz;
					break;
				}
				else if(flag1) {
					tot+=s1;
					break;
				}
				else if(flag2) {
					tot+=s2;
					break;
				}
			}
		//	if(num2<0) tot=Integer.MAX_VALUE;
		}
		else {
			tot+=N.length();
		}
		if(temp<tot) {
			tot=temp;
		}
		
		System.out.println(tot);
	}
	
	private static void delete(char ch) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)==ch) {
				list.remove(i);
			}
		}
	}

	private static boolean check(String s) {
		
		for (int i = 0; i < s.length(); i++) {  //최대 6
			char c=s.charAt(i);
			boolean flag=false;
			for (int j = 0; j < list.size(); j++) {  //최대 10
				if(list.get(j)==c) {
					flag=true;
					break;
				}
			}
			if(!flag)
				return false;
		}
		return true;
	}

}
