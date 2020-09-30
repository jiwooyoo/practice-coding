#include<iostream> 
#include<algorithm>
#include<string>
#include<queue>
#include<stack>
#include<vector>
#include<memory.h>
#include<deque>

#define INF 987654321
#define MAX 10002

using namespace std;   //표준 입출력을 위해
vector<int> v;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	//priority_queue < int, vector < int >, greater<int> > q;
	priority_queue<int> q;

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int key;
		cin >> key;
		q.push(-1*key);
	}

	int re = 0;
	while (q.size() > 1) {
		int n1 = -1*q.top();
		q.pop();
		int n2 = -1*q.top();
		q.pop();
		re += (n1 + n2);
		q.push(-1*(n1 + n2));
	}

	cout << re << "\n";
}
