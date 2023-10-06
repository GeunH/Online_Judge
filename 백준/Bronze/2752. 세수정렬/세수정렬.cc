#include <iostream>
#include <algorithm>

using namespace std;

void init() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);
}

int main() {
	init();
	int a[3] = { 0 }, b[3] = { 0 };

	for (int i = 0; i < 3; i++) {
		cin >> a[i];
	}
	sort(a, a + 3);

	for (int i = 0; i < 3; i++) {
		cout <<  a[i] << " ";
	}
	
	return 0;
}