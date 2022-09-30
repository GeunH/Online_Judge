#include <iostream>

using namespace std;

int T[15], P[15];
int last = 0;

void max_profit(int N, int profit, int day)
{
	if (day > N)return;
	if (profit > last)
	{
		last = profit;
	}
	if (day == N)return;

	max_profit(N, profit , day+1);
	max_profit(N, profit + P[day], day + T[day]);
}

int main()
{
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> T[i] >> P[i];
	}

	max_profit(N, 0, 0);
	cout << last;
	return 0;
}