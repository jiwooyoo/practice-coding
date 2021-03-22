import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_BOJ_20299 {
	static int N,S,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] s=br.readLine().trim().split(" ");
		N=Integer.parseInt(s[0]);  //신청 동아리 수
		S=Integer.parseInt(s[1]);  //스마트 클럽 가입조건
		M=Integer.parseInt(s[2]);  //멤버별 능력치 조건
		StringBuffer sb=new StringBuffer();
		List<String> list=new ArrayList<>();  //최종 멤버들 저장할 리스트
		
		int tot=0;
		for (int i = 0; i < N; i++) {
			
			String[] s1=br.readLine().trim().split(" ");  //라인 단위로 입력받은 후 나누기
			int sum=0;
			boolean flag=true;
			for (int j = 0; j < 3; j++) {
				int num=Integer.parseInt(s1[j]);  //멤버별로 입력받기
				if(num<M) {  //멤버 능력치 아래면 클럽 탈락
					flag=false;
					break;  //멈추고 다음 클럽 후보로 넘어가기
				}
				else sum+=num;  //이상이면 S비교 위해 클럽 능력치에 더하기
			}
			
			if(flag&&sum>=S) {  //멤버 모두 능력치 조건 충족하고 클럽 능력치에도 충족하면
				tot++;   //클럽에 통과되었으므로 수 늘리기
				for (int j = 0; j < s1.length; j++) {
					list.add(s1[j]);  //멤버 한명씩 최종 리스트에 저장
					sb.append(s1[j]+" ");
				}
			}
		}
		
		System.out.println(tot);  //통과한 최종 클럽수&멤버 출력하기
		/*for (String i : list) {
			System.out.print(i+" ");
		}*/
		System.out.println(sb);
	}

}
