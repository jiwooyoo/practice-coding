import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_17413 {

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringBuffer sb=new StringBuffer();
		StringBuffer temp=new StringBuffer();
		
		for (int i = 0; i < s.length(); i++) {
			char ch=s.charAt(i);
			if(ch=='<') {
				sb.append(getReverse(temp));
				temp.setLength(0);
				while(ch!='>') {
					sb.append(ch);
					i++;
					ch=s.charAt(i);
				}
				sb.append(ch);
			}else if(ch==' ') {
				sb.append(getReverse(temp));
				sb.append(ch);
				temp.setLength(0);
			}else {
				temp.append(ch);
			}
			
			if(i==s.length()-1) {
				if(temp!=null) {
					sb.append(getReverse(temp));
				}
			}
		}
		
		System.out.println(sb);
	}

	private static StringBuffer getReverse(StringBuffer temp) {
		return temp.reverse();
	}

}
