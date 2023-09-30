#include <iostream>

using namespace std;

int num[250000];

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int N, X;
	cin >> N >> X;
	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}

	int start = 0;
	int end = X;

	int sum = 0, sumCnt = 1;
	for (int i = start; i < end; i++) {
		sum += num[i];
	}
	int maxSum = sum;
	while (end  < N) {
		start++;
		if (sum - num[start-1] + num[end] == maxSum) {
			sumCnt++;
		}
		else if (sum - num[start-1] + num[end ] > maxSum) {
			maxSum = sum - num[start-1] + num[end];
			sumCnt = 1;
		}
		sum = sum - num[start-1] + num[end];
		end++;
	}
	if (maxSum == 0)cout << "SAD";
	else cout << maxSum << '\n' << sumCnt;
	return 0;
}