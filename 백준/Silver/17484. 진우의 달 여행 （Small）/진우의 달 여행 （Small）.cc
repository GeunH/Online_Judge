#include <iostream>

using namespace std;

void init() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);
}

int map[6][6];
int minFuel = 700;

void move(int N, int M, int h, int i, int dir, int sum) {
	if (i < 0 || i >= M)return;
	sum += map[h][i];
	if (h == N - 1) {
		if (minFuel > sum)minFuel = sum;
	}
	else {
		if (dir == 0) {
			move(N, M, h + 1, i - 1, -1, sum);
			move(N, M, h + 1, i + 1, 1, sum);
		}
		else if (dir == -1) {
			move(N, M, h + 1, i, 0, sum);
			move(N, M, h + 1, i + 1, 1, sum);
		}
		else if (dir == 1) {
			move(N, M, h + 1, i - 1, -1, sum);
			move(N, M, h + 1, i, 0, sum); 
		}
		else {
			move(N, M, h + 1, i - 1, -1, sum);
			move(N, M, h + 1, i, 0, sum);
			move(N, M, h + 1, i + 1, 1, sum);
		}
	}
}

int main() {
	init();
	int N, M;

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < M; i++) {
		move(N, M, 0, i, 2, 0);
	}
	cout << minFuel;
	return 0;
}