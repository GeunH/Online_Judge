#include <iostream>

using namespace std;

void init() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);
}

int cnt[26];
int firstLength;

void firstWord(string a) {
	for (int i = 0; i < a.length(); i++) {
		cnt[a[i] - 'A']++;
	}
	firstLength = a.length();
}

bool checkWord(string a) {
	int checkCnt[26] = {0,};
	for (int i = 0; i < a.length(); i++) {
		checkCnt[a[i] - 'A']++;
	}
	
	int dif = 0;
	for (int i = 0; i < 26; i++) {
		if (checkCnt[i] == cnt[i])continue;
		if (checkCnt[i] - 1 == cnt[i] || checkCnt[i] + 1 == cnt[i]) {
			dif++;
		}
		else return false;
	}
	if (firstLength - a.length() < -1 && firstLength - a.length() > 1)return false;
	else if (dif <= 2)return true;
	else return false;
}

int main() {
	init();

	int N;
	cin >> N;
	string a;
	int result = 0;
	for (int i = 0; i < N; i++) {
		cin >> a;
		if (i == 0)firstWord(a);
		else if (checkWord(a))result++;
	}

	cout << result;
	
	return 0;
}