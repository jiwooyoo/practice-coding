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
int n, l, r;
int re = 0;
int arr[52][52];
bool visit[52][52];

void dfs(int x, int y, int cnt) {	
	vector<pair<int, int> > v;
	v.push_back({ x,y });

	queue<pair<int, int> > q;
	q.push({ x,y });

	visit[x][y] = true;
	int sum = arr[x][y];
	int num = 1;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if (visit[nx][ny] == false) {
				int gap = abs(arr[nx][ny] - arr[x][y]);
				if (gap >= l && gap <= r) {
					q.push({ nx,ny });
					visit[nx][ny] = true;
					sum += arr[nx][ny];
					num++;
					v.push_back({ nx,ny });
				}
			}
		}

	}

	for (int i = 0; i < v.size(); i++) {
		int a = v[i].first;
		int b = v[i].second;
		arr[a][b] = sum / num;
	}

}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> l >> r;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}

	while (true) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = false;
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == false) {
					//visit[i][j] = true;
					dfs(i, j, cnt);
					cnt += 1;
				}
			}
		}

		if (cnt == n * n) break;
		re++;
	}

	
	cout << re << "\n";
}
