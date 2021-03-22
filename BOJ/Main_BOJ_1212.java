import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1212 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int len=s.length();
		int[] pow= {1,2,4};
		char[] res;
		
		int arr_size=0,index=0;
		
		if(s.charAt(0)-'0'<2){
			arr_size=3*(len-1)+1;
			index=0;
		}else if(s.charAt(0)-'0'<4) {
			arr_size=3*(len-1)+2;
			index=1;
		}
		else{
			arr_size=3*len;
			index=2;
		}
		res=new char[arr_size];
	//	System.out.println(arr_size);
		
		int i=2;
		while(--len>=0) {
			int num=s.charAt(len)-'0';
			if(arr_size<3) {
				i=index;
			}
			while(i>=0) {
				res[arr_size-1-i]=(char) (num/pow[i]+'0');
			//	System.out.println(res[arr_size-1]);
				num%=pow[i];
				i--;
			}
			i=2;
			arr_size-=3;
		}
/*		
		if(arr_size!=0) {
			int num=(s.charAt(len)-'0');
			while(arr_size!=0) {
				res[arr_size-1]=(char) (num/pow[arr_size-1]+'0');
				num%=pow[arr_size-1];
				arr_size--;
			}
		} */
		System.out.println(new String(res));
	}

}
