#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;

    for(int i=n;i>0;i--){
        int num=s/i;

        if(num<=0){
            answer.push_back(-1);
            break;
        } 
        else
            answer.push_back(num);
        s=s-num;
    }

    return answer;
}
