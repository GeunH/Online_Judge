#include <iostream>

using namespace std;

void init() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);
}

int main() {
	init();
	long long a, b;

	cin >> a >> b;

	cout << (a + b) * (a - b);

	return 0;
}