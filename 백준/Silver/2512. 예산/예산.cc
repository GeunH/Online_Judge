#include <iostream>

using namespace std;

int arr[10000];

bool check(int mid, int N, int M)
{
	int total = M;
	for (int i = 0; i < N; i++) {
		if (mid < arr[i]) total -= mid;
		else total -= arr[i];
		if (total < 0)return false;
	}
	return true;
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int N,M;

	cin >> N;

	int maxNum = 0;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		if (maxNum < arr[i]) maxNum = arr[i];
	}

	cin >> M;

	int left = M/N, right = maxNum> M ? M : maxNum;
	int mid = (left + right) / 2;
	while (left <= right) {
		if (check(mid, N, M)) {
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
		mid = (left + right) / 2;
		maxNum = mid;
	}
	

	cout << maxNum;

	return 0;
}