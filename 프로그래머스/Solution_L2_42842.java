
public class Solution_L2_42842 {

	public static void main(String[] args) {

		int brown=24;
		int yellow=24;
		int sum=(brown+4)/2;
		
		int width=0,height=0;
		for (int i = 1; i <= (sum+1)/2; i++) {
			width=sum-i;
			height=i;
		//	System.out.println(width+" "+height);
			if((width-2)*(height-2)==yellow) {
				break;
			}
		}
		
		System.out.println(width+" "+height);
	}

}
