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
vector<int> re;
int arr[4];
int n;

void dfs(int sum, int num, int index) {	

	if (index == 0) {
		sum = sum + v[num];
	}
	else if (index == 1) {
		sum = sum - v[num];
	}
	else if (index == 2) {
		sum = sum * v[num];
	}
	else {
		sum = sum / v[num];
	}

	if (num == n-1) {
		re.push_back(sum);
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (arr[i] == 0) continue;
		arr[i] -= 1;
		dfs(sum, num+1, i);
		arr[i] += 1;
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		int key;
		cin >> key;
		v.push_back(key);
	}

	for (int i = 0; i < 4; i++) {
		cin >> arr[i];
	}

	dfs(0, 0, 0);

	sort(re.begin(), re.end());

	//cout << re.size() << "\n";
	cout << re[re.size() - 1] << "\n";
	cout << re[0] << "\n";
}
