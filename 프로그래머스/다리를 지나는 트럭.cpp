#include <string>
#include <vector>
#include <deque>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    queue<int> q;
    
    int sum=0;
    int num;
    for(int i=0;i<truck_weights.size();i++){
        num=truck_weights[i];
        while(1){
            if(q.empty()){
                q.push(num);
                answer++;
                sum+=num;
                break;
            }
            else if(q.size()==bridge_length){
                sum-=q.front();
                q.pop();
            }
            else{
                if(sum+num>weight){
                    q.push(0);
                    answer++;
                }
                else{
                    q.push(num);
                    answer++;
                    sum+=num;
                    break;
                }
            }
        }
    }
    
    return answer+bridge_length;
}
