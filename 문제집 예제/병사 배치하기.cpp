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

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	vector<int> v;
	int dp[2002];

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		dp[i] = 1;
	}

	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}

	reverse(v.begin(), v.end());

	for (int i = 1; i < n; i++) {
		for (int j = 0; j < i; j++) {
			if (v[j] < v[i]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
	}

    int res=dp[0];
    for(int i=1;i<n;i++)
        res=max(res,dp[i]);
	cout << n-res << "\n";
}
