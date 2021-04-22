import java.util.Scanner;

public class Main_BOJ_1790 {

	static int N,k;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		k=sc.nextInt();
		int res=0;
		if(cal(N)<k) {
			res=-1;  // N까지의 길이가 k보다 작을 때  
			System.out.println(res);
		}
		else {
			res=find();   // 길이가 K가 되는 숫자의 값 
			int len=cal(res);  // 그 숫자까지의 총 길이 ( 숫자가 1자리수가 아닌경우, 그 수의 몇번째 자리인지 파악 위해 )
			String s=Integer.toString(res);
			int index=k+s.length()-len-1; // len-s.length()+k : 현재 앞숫자까지의 길이  인덱스이므로 1 빼ㄴ줌 
			System.out.println(s.charAt(index));
		}
	}

	// 1번부터 n번 숫자까지의 길이를ㄹ 구해주는 함수 
	private static int cal(int n) {
		int cnt=0;
		int digit=1;
		for (int i = 1; i <= n; i*=10) {
			int end=i*10-1;
			if(n<end) {
				end=n;
			}
			cnt+=(end-i+1)*digit;
			digit++;
		}
		return cnt;
	}
	
	private static int find() {  // 길이를 K 값을 만족하는 숫자 반환 
		int left=1;
		int right=N;
		int res=0;
		while(left<=right) {
			int mid=(left+right)/2;  // 중간부터 시작 
			int len=cal(mid);   // mid 까지의 길이 
			if(len<k) {
				left=mid+1;
			}
			else {
				res=mid;  // 정확히 일치하는 경우가 항상 있는것은 아니므로 계속해서 가까운 값으로 갱신하는 것 
				right=mid-1;
			}
		}
		return res;
	}
}
