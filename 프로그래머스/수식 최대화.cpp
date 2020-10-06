#include <vector>
#include <algorithm>
#include <queue>
#include <stack>
#include <string>
#include <cstdlib>

using namespace std;

long long solution(string expression) {
    long long answer = 0;
    
    vector<long long> v;
    vector<char> op, index;

    bool check1=false;
    bool check2=false;
    bool check3=false;

    string s="";
    for(int i=0;i<expression.size();i++){
        if(expression[i]>='0'&&expression[i]<='9'){
            s+=expression[i];
        }
        if(expression[i]=='+'||expression[i]=='-'||expression[i]=='*'){
            v.push_back(stoi(s));
            s="";
            index.push_back(expression[i]);
            if(expression[i]=='+') check1=true;
            if(expression[i]=='-') check2=true;
            if(expression[i]=='*') check3=true;
        }
    }
    v.push_back(stoi(s));
    if(check1) op.push_back('+');
    if(check2) op.push_back('-');
    if(check3) op.push_back('*');

    sort(op.begin(),op.end());
    
    do{
        vector<long long> ev=v;
        vector<char> eindex=index;
        
        for(int i=0;i<op.size();i++){
            for(int j=0;j<eindex.size();j++){
                if(op[i]==eindex[j]){
                    if(eindex[j]=='+')
                        ev[j]=ev[j]+ev[j+1];
                    else if(eindex[j]=='-')
                        ev[j]=ev[j]-ev[j+1];
                    else if(eindex[j]=='*')
                        ev[j]=ev[j]*ev[j+1];
                    
                    ev.erase(ev.begin()+j+1);
                    eindex.erase(eindex.begin()+j);
                    j--;
                }
            }
        }
        answer=max(answer,abs(ev[0]));
    }while(next_permutation(op.begin(),op.end()));

    return answer;
}
