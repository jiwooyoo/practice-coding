#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int GCD(int a, int b){
    while(a%b!=0){
        int c=a;
        a=b;
        b=c%b;
    }
    return b;
}

int LCM(int a, int b){
    return (a*b)/GCD(a,b);
}
int solution(vector<int> arr) {
    int answer = 0;

    int index=1;
    for(int i=0;i<arr.size();i++){
        index=LCM(index,arr[i]);
    }

    answer=index;
    return answer;
}
