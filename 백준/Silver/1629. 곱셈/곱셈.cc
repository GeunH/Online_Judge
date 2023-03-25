#include <iostream>

using namespace std;

long long multiple(long long A, long long B, long long C)
{
	long long sum;
	if (B == 1)return A % C;
	if (B % 2 == 0)
	{
		sum = multiple( (A%C) * (A%C), B / 2, C);
	}
	else
	{
		sum = ((A%C) * multiple((A % C) * (A % C), (B -1)/ 2, C))%C;
	}
	return sum;
}

int main()
{
	unsigned long long A, B, C;
	cin >> A >> B >> C;
	
	long long sum = multiple(A, B, C);
	cout << sum;
	return 0;
}