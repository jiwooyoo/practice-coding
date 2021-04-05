import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_7555 {

	static int T;
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String s1=br.readLine().trim();
			String s2=br.readLine().trim();
			int len1=s1.length();
			int len2=s2.length();
			
			int lcd=LCD(len1,len2);
			StringBuffer sb1=new StringBuffer();
			sb1.append(s1);
			StringBuffer sb2=new StringBuffer();
			sb2.append(s2);
			for (int i = 0; i < lcd/len1-1; i++) {
				sb1.append(s1);
			}
			
			for (int i = 0; i < lcd/len2-1; i++) {
				sb2.append(s2);
			}
		//	sb1.equals(sb2)
			//System.out.println(s1);
			//System.out.println(s2);
			int res=0;
			
			if(sb1.toString().equals(sb2.toString())) res=1;
			System.out.println("#"+t+" "+res);
		}
		
	}

	static int GCD(int a,int b) {
		while(b!=0) {
			int temp=b;
			b=a%b;
			a=temp;
		}
		
		return a;
	}
	
	static int LCD(int a,int b) {
		int gcd=GCD(a,b);
		return (a*b)/gcd;
	}
}
