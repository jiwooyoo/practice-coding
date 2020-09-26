#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    
    for(int i=0;i<prices.size();i++){
        int j=i;
        //int sum=0;
        while(prices[i]<=prices[j] && j!=prices.size()-1){
            j++;
        }
        answer.push_back(j-i);
    }
    
    return answer;
}
