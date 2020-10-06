#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int low=0,high=people.size()-1;
    
    sort(people.begin(),people.end());
    
    while(low<=high){
        if(people[low]+people[high]<=limit){
            low++;
            high--;
        }
        else{
            high--;
        }
        
        answer++;
    }
    return answer;
}
