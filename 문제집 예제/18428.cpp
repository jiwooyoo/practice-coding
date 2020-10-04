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
int dir[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
char arr[10][10];
int n;
int re = 0;

bool check(int x, int y) {
	for (int i = y-1; i >= 0; i--) {
		if (arr[x][i] == 'S') {
			return false;
		}
		if (arr[x][i] == 'O') {
			break;
		}
	}
	for (int i = y + 1; i < n; i++) {
		if (arr[x][i] == 'S') {
			return false;
		}
		if (arr[x][i] == 'O') {
			break;
		}
	}

	for (int i = x - 1; i >= 0; i--) {
		if (arr[i][y] == 'S') {
			return false;
		}
		if (arr[i][y] == 'O') {
			break;
		}
	}
	for (int i = x + 1; i < n; i++) {
		if (arr[i][y] == 'S') {
			return false;
		}
		if (arr[i][y] == 'O') {
			break;
		}
	}

	return true;
}

bool teacher() {
	bool res = true;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 'T') {
				res = check(i, j);
				if (res == false) break;
			}
		}
		if (res == false) break;
	}

	return res;
}

void dfs(int cnt) {
	if (cnt == 3) {
		if (teacher() == true) {
			re = 1;
			return;
		}
		else {
			return;
		}

	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 'X') {
				arr[i][j] = 'O';
				dfs(cnt + 1);
				arr[i][j] = 'X';
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}

	dfs(0);
	if (re == 1) cout << "YES\n";
	else cout << "NO\n";
}
