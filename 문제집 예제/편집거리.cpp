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

	string A, B;
	cin >> A;
	cin >> B;

	int n = A.size();
	int m = B.size();

	vector<vector<int> > v(n+1, vector<int>(m+1));

	for (int i = 0; i <= n; i++) {
		v[i][0] = i;
	}
	for (int i = 0; i <= m; i++) {
		v[0][i] = i;
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (A[i-1] == B[j-1]) {
				v[i][j] = v[i - 1][j - 1];
			}
			else {
				v[i][j] = 1 + min(v[i][j - 1], min(v[i - 1][j], v[i - 1][j - 1]));
			}
		}
	}

	cout << v[n][m] << "\n";
}
