#include <iostream>

using namespace std;

long long oil[1000];
long long way[1000];
unsigned long long sum;

int main()
{
	int N;
	cin >> N;

	for (int i = 0; i < N-1; i++)
	{
		cin >> way[i];
	}
	for (int i = 0; i < N; i++)
	{
		cin >> oil[i];
	}
	sum += way[0] * oil[0];

	int last = 0;
	for (int i = 1; i < N-1; i++)
	{
		if (oil[last] > oil[i])
		{
			last = i;
		}
		sum += oil[last] * way[i];
	}
	cout << sum;
	return 0;
}