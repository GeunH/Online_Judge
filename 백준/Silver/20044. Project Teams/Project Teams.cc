#include <iostream>
#include <algorithm>

using namespace std;

int student[10000];

int main() {
	int N, stuNum;
	cin >> N;
	stuNum = N * 2;
	for (int i = 0; i < stuNum; i++) {
		cin >> student[i];
	}

	sort(student, student+ stuNum);

	int Sm = student[0] + student[stuNum - 1];

	for (int i = 0; i < stuNum / 2; i++) {
		if (Sm > student[i] + student[stuNum - 1 - i])Sm = student[i] + student[stuNum - 1 - i];
	}
	cout << Sm;
	return 0;
}