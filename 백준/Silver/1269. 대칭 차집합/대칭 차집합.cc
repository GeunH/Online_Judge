#include <iostream>
#include <map>

using namespace std;

map<int, int> A;

int main()
{
	int a, b, num;
	cin >> a >> b;

	for (int i = 0; i < a; i++)
	{
		cin >> num;
		A.insert({ num,1 });
	}
	int cnt = 0;
	for (int j = 0; j < b; j++)
	{
		cin >> num;
		if (A[num] == 1) {
			cnt++;
		}
	}
	cout << a + b - 2*cnt;

	return 0;
}