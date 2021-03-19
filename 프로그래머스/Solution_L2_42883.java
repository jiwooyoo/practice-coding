import java.util.Stack;

/* 큰수 만들기 */
public class Solution_L2_42883 {
	
	public static void main(String[] args) {
		String number="1231234";
		int k=3;
		int len=number.length()-k;
		StringBuffer sb=new StringBuffer();
		int index=0;
		char max='0';
		
		for (int i = 0; i < len; i++) {
			max='0';
			for (int j = index; j <= k+i; j++) {
				if(max<number.charAt(j)) {
					max=number.charAt(j);
					index=j+1;  //그 다음 자리부터 찾는것
				}
			}
			
			sb.append(max);
		}
	
		System.out.println(sb);
	}

}
