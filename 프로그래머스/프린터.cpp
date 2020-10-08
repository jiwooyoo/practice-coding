#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    priority_queue<int> pq;
    queue<pair<int,int> > q;
    
    for(int i=0;i<priorities.size();i++){
        q.push({priorities[i],i});
        pq.push(priorities[i]);
    }
    
    while(!pq.empty()){
        int num=pq.top();
        pq.pop();
        
        int pri=q.front().first;
        int order=q.front().second;
        q.pop();
        while(num!=pri){
            q.push({pri,order});
            pri=q.front().first;
            order=q.front().second;
            q.pop();
        }
        answer++;
        if(order==location) break;
    }
    
    return answer;
}
