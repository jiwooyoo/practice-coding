import java.util.Scanner;

public class Main_BOJ_1373 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int len=s.length();
		int[] pow= {1,2,4};
		char[] oc;
		int i=0;
		if(len%3==0) {
			oc=new char[len/3];
			i=len/3-1;
		}
		else {
			oc=new char[len/3+1];
			i=len/3;
		}
		
		int temp=0,tot;
		int index=0;
		while(--len>=0) {
			temp+=(s.charAt(len)-'0')*pow[index];
			if(index==2) {
				oc[i]=(char) (temp+'0');
				i--;
				temp=0;
				index=0;
			}else {
				index++;
			}
		}
		
		if(i==0) {
			oc[0]=(char) (temp+'0');
		}
		
		/*for (int j = 0; j < oc.length; j++) {
			System.out.print(oc[j]);
		}*/
		System.out.println(new String(oc));
	}

}
