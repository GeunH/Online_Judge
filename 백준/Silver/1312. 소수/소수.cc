#include <iostream>

using namespace std;

int main()
{
	int a, b, c, ret;
	cin >> a >> b >> c;
	while (c--) {
		a %= b;
		a *= 10;
		ret = a / b;
	}
	cout << ret;
	return 0;
}