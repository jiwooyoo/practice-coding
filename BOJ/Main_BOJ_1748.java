import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1748 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int len=s.length();
		int num=Integer.parseInt(s);
		long[] arr=new long[9];
		long index=1;
		for (int i = 1; i < 9; i++) {
			arr[i]=9*index*i;
			index*=10;
		}
		
		long res=0;
		
		if(len==9) {
			res=9+arr[8]+arr[7]+arr[6]+arr[5]+arr[4]+arr[3]+arr[2]+arr[1];
		}
		else if(len==8) {
			res=(num-9999999)*8+arr[7]+arr[6]+arr[5]+arr[4]+arr[3]+arr[2]+arr[1];
		}
		else if(len==7) {
			res=(num-999999)*7+arr[6]+arr[5]+arr[4]+arr[3]+arr[2]+arr[1];
		}
		else if(len==6) {
			res=(num-99999)*6+arr[5]+arr[4]+arr[3]+arr[2]+arr[1];
		}
		else if(len==5) {
			res=(num-9999)*5+arr[4]+arr[3]+arr[2]+arr[1];
		}
		else if(len==4) {
			res=(num-999)*4+arr[3]+arr[2]+arr[1];
		}
		else if(len==3) {
			res=(num-99)*3+arr[2]+arr[1];
		}
		else if(len==2) {
			res+=(num-9)*2;
			res+=arr[1];
		}
		else {
			res=num;
		}
		
		System.out.println(res);
	}

}
