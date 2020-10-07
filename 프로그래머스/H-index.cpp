#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;

    sort(citations.begin(),citations.end());
    int high=citations[citations.size()-1];


    for(int i=high;i>=0;i--){
        int cnt=0;
        for(int j=0;j<citations.size();j++){
            if(citations[j]>=i) cnt++;
        }
        if(cnt>=i && (citations.size()-cnt)<=i){
            answer=i;
            break;
        }
    }

    return answer;
}
