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
	string a;
	int cntZero = 0, cntOne = 0;
	cin >> a;

	for (int i = 0; i < a.length(); i++) {
		if (a[i] == '0')cntZero++;
		else cntOne++;
	}

	string b="";

	for (int i = 0; i < cntZero/2; i++) {
		b += '0';
	}
	for (int i = 0; i < cntOne/2; i++) {
		b += '1';
	}
	cout << b;
	
	return 0;
}