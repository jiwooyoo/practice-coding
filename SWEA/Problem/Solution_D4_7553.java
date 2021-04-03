import java.math.BigInteger;
import java.util.Scanner;

public class Solution_D4_7553 {

	static int T,i=2;;
	static BigInteger N,res;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextBigInteger();
			res=BigInteger.ZERO;
			
			binary(BigInteger.ZERO,N,N.divide(BigInteger.valueOf(i)));
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void binary(BigInteger start,BigInteger end,BigInteger mid) {
		if(mid.multiply(mid).compareTo(N)==0) {
			res=mid;
			return;
		}
		else if(mid.multiply(mid).compareTo(N)==1) {  //작으
			end=mid;
			mid=start.add(end).divide(BigInteger.valueOf(i));
		}
		else {
			start=mid;
			mid=start.add(end).divide(BigInteger.valueOf(i));
		}
		
		binary(start,end,mid);
	}

}
