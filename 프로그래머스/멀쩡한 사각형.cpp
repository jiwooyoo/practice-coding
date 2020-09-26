using namespace std;

int gcd(int n1, int n2){
    if(n1%n2==0) return n2;
    return gcd(n2, n1%n2);
}

long long solution(int w,int h) {
    long long answer = (long long)w * (long long)h;
    int g;
    
    if(w>h) g=gcd(w,h);
    else g=gcd(h,w);
    
    int g_w=w/g;
    int g_h=h/g;
    
    answer = answer - (g_w+g_h-1)*g;
    
    return answer;
}
