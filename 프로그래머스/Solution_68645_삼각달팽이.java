
public class Solution_68645_삼각달팽이 {

	static int n=6;
	static int[] dr= {1,0,-1};
	static int[] dc= {0,1,-1};
	public static void main(String[] args) {
		
		int tot=n*(n+1)/2;
        int[] answer = new int[tot];
        
        int[][] arr=new int[n][n];
		int num=1;
		int tempN=n;
        int cnt=n;
		int r=0,c=0,dir=0;
		int index=0;
		while(num<=tot) {
			arr[r][c]=num++;
            index++;
			if(index==cnt){
                dir=(dir+1)%3;
                cnt--;
                index=0;
            }
			r=r+dr[dir];
			c=c+dc[dir];
		}
		
		for (int i = 0; i < tempN; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
	}

}
