#include <vector>
// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
using namespace std;
int arr[102][102];
bool visit[102][102];
int dir[4][2]={{-1,0},{0,-1},{1,0},{0,1}};
int cnt=0;
int mm,nn;

void dfs(int x,int y,int num){
    visit[x][y]=true;
    cnt++;
    
    for(int i=0;i<4;i++){
        int nx=x+dir[i][0];
        int ny=y+dir[i][1];
        
        if(nx<0||ny<0||nx>=mm||ny>=nn||visit[nx][ny]) continue;
        if(arr[nx][ny]==num){
            dfs(nx,ny,num);
        }
    }
}

vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    
    mm=m;
    nn=n;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            arr[i][j]=picture[i][j];
            visit[i][j]=false;
        }
    }
    
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(!visit[i][j]&&arr[i][j]!=0){
                cnt=0;
                number_of_area++;
                dfs(i,j,arr[i][j]);
                max_size_of_one_area=max(max_size_of_one_area,cnt);
            }
        }
    }
    vector<int> answer(2);    
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}
