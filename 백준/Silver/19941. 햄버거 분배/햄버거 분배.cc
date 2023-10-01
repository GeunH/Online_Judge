#include <iostream>

using namespace std;

void init() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);
}

char arr[20000];

bool findBurger(int N, int K, int i) {
	for (int j = K; j >= -K ; j--) {
		if (i - j >=0 && i - j < N && arr[i - j] == 'H') {
			arr[i - j] = 'E';
			return true;
		}
	}
	return false;
}

int main() {
	init();
	int N, K;

	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		if ( arr[i] == 'P' && findBurger(N, K, i))cnt++;
	}
	cout << cnt;
	return 0;
}