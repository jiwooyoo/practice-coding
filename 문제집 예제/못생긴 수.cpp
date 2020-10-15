#include<iostream> 
#include<algorithm>
#include<string>
#include<queue>
#include<stack>
#include<vector>
#include<memory.h>
#include<deque>
#include<string>

#define INF 987654321
#define MAX 10002

using namespace std;   //표준 입출력을 위해

bool check(int n) {
	while (n != 1) {
		if (n % 2 == 0) {
			n /= 2;
		}
		else if (n % 3 == 0) {
			n /= 3;
		}
		else if (n % 5 == 0) {
			n /= 5;
		}
		else {
			return false;
		}
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	vector<int> v;

	int n;
	cin >> n;

	int num = 1;
	int cnt = 1;
	v.push_back(num);
	while (1) {
		num++;
		if (check(num)) {
			v.push_back(num);
			cnt++;
		}		
		if (cnt == n) break;
	}

	cout << v[n - 1] << "\n";
}
