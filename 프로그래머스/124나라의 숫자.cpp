#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    int num=n;
    int re;
    
    while(num!=0){
        re=num%3;
        num=num/3;
        
        if(re==0){
            answer="4"+answer;
            num--;
        }
        else if(re==1){
            answer="1"+answer;
        }
        else{
            answer="2"+answer;
        }
    }
    
    return answer;
}
